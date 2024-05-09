package com.mundo.etl.spark.sql

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import org.apache.spark.sql.{Row, RowFactory, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  本地测试合并数据，完整版
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object MergerData6Suite {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerData5Suite").setMaster("local[2]")
    // 初始化SparkContext
    val sc = new SparkContext(conf)
    // 初始化SQLContext
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val dbDF = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    dbDF.registerTempTable("site_priority_policy")
    val priorityDF = sqlContext.sql("select * from site_priority_policy order by priority")
    val policyCollect = priorityDF.select("retailerid", "priority", "validity").map(row => {
      val retailerid = row.getString(0)
      val priority = row.getString(1)
      val validity = row.getString(2)
      val result = retailerid + connectStr + priority + connectStr + validity + connectStr
      result
    }).collect()

//    priorityDF.collect()(0).getString(1)

    import sqlContext.implicits._
    // 测试数据
    val seq = List(
      ("a", "value1", "", "2017-11-05", "X0100013", ""),
      ("a", "value2", "value3", "2017-11-07", "X0100059", ""),
      ("b", "value4", "", "2017-11-19", "Z0100030", ""),
      ("b", "value5", "", "2017-11-22", "Z0100030", ""),
      ("b", "value6", "value7", "2017-11-10", "X0100059", ""))

    val dataFrame = seq.toDF("column1", "column2", "column3", "bizdate", "retailerid", "column4")
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
    // 将数据表数据映射成(key, columns(通过connectStr连接) + 时间字段索引 + 字段主键ID索引)
    val mappedRdd = dataFrame.rdd.map(item => {
      val createTimeIndex = item.fieldIndex("bizdate")
      val retaileridIndex = item.fieldIndex("retailerid")
      (item.getString(0), (item, createTimeIndex, retaileridIndex))
    })

    val rowRDDItems = mappedRdd.reduceByKey((item1, item2) => {

      val maxd = math.max(item1._1.size, item2._1.size)

      val bizdateIndex1 = item1._2
      val bizdateIndex2 = item2._2
      val retaileridIndex1 = item1._3
      val retaileridIndex2 = item2._3

      // 获取倒2个记录索引值
      val date1Str = item1._1.getString(bizdateIndex1)
      val date2Str = item2._1.getString(bizdateIndex2)
      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)
      val item1Retailerid = item1._1.getString(retaileridIndex1)
      val item2Retailerid = item2._1.getString(retaileridIndex2)

      var conditionStr1 = ""
      var conditionStr2 = ""

      for (collectItem <- policyCollect) {
        if (collectItem.contains(item1Retailerid)) {
          conditionStr1 = collectItem
        }
        if (collectItem.contains(item2Retailerid)) {
          conditionStr2 = collectItem
        }
      }

      val condition1Splits = conditionStr1.split(connectStr)
      val condition2Splits = conditionStr2.split(connectStr)

      val priority1 = condition1Splits(1).toInt
      val validity1 = condition1Splits(2).toInt
      val priority2 = condition2Splits(1).toInt
      val validity2 = condition2Splits(2).toInt

      val calendar = Calendar.getInstance()
      val nowTime = calendar.getTime
      calendar.setTime(date1)
      calendar.add(Calendar.DATE, validity1)
      val item1ExpireTime = calendar.getTime
      calendar.setTime(date2)
      calendar.add(Calendar.DATE, validity2)
      val item2ExpireTime = calendar.getTime

      var result = ""
      for (i <- 0 until maxd) {
        var itemValue1 = item1._1.getString(i)
        var itemValue2 = item2._1.getString(i)

        if (itemValue1 == null || itemValue2 == null) {
          if (itemValue1 == null) {
            if (itemValue2 == null) {
              itemValue2 = "NULL"
            }
            result += itemValue2 + connectStr
          } else {
            if (itemValue1 == null) {
              itemValue1 = "NULL"
            }
            result += itemValue1 + connectStr
          }
        } else if ("".equalsIgnoreCase(itemValue1.trim) || "".equalsIgnoreCase(itemValue2.trim) || "NULL".equalsIgnoreCase(itemValue1) || "NULL".equalsIgnoreCase(itemValue2)) {
          if ("NULL".equalsIgnoreCase(itemValue1) || "NULL".equalsIgnoreCase(itemValue2)) {
            if ("NULL".equalsIgnoreCase(itemValue1)) {
              if ("".equalsIgnoreCase(itemValue2.trim)) {
                itemValue2 = "NULL"
              }
              result += itemValue2 + connectStr
            } else {
              if ("".equalsIgnoreCase(itemValue1.trim)) {
                itemValue1 = "NULL"
              }
              result += itemValue1 + connectStr
            }
          } else {
            if ("".equalsIgnoreCase(itemValue1.trim) && "".equalsIgnoreCase(itemValue2.trim)) {
              result += "NULL" + connectStr
            } else {
              result += (itemValue1 + itemValue2) + connectStr
            }
          }
        } else {
          result = createResultContent(priority1, priority2, nowTime, item1ExpireTime, item2ExpireTime, result, itemValue1, itemValue2)
        }
      }
      println(result)
      val resultSplites = result.split(connectStr)
      println(resultSplites.length)
      val columnBean = createTableBean(resultSplites.length, resultSplites)
      (columnBean, item1._2, item1._3)
    })
    val rowRDD = rowRDDItems.map(_._2._1)
    sqlContext.createDataFrame(rowRDD, dataFrame.schema).show()

    sc.stop()

  }

  private def createResultContent(priority1: Int, priority2: Int, nowTime: Date, item1ExpireTime: Date, item2ExpireTime: Date, src: String, itemValue1: String, itemValue2: String) = {
    var result = src
    if (priority1 <= priority2) { // priority1优先级高
      if (item1ExpireTime.getTime < nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime) {
        result += itemValue2 + connectStr
      } else {
        if (item1ExpireTime.getTime >= nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime && item1ExpireTime.getTime < item2ExpireTime.getTime) {
          result += itemValue2 + connectStr
        } else {
          result += itemValue1 + connectStr
        }
      }
    } else {
      if (item2ExpireTime.getTime < nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime) {
        result += itemValue1 + connectStr
      } else {
        if (item2ExpireTime.getTime >= nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime && item2ExpireTime.getTime < item1ExpireTime.getTime) {
          result += itemValue1 + connectStr
        } else {
          result += itemValue2 + connectStr
        }
      }
    }

    result
  }

  def createTableBean(columnLength: Int, splits: Array[String]): Row = {
    columnLength match {
      case 8 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7))
        columnBean

      case 6 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5))
        columnBean

      case 5 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4))
        columnBean

    }
  }

}
