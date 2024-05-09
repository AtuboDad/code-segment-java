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
object MergerData5Suite {

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
      val result = retailerid + connectStr + priority + connectStr + validity
      println(result)
      result
    }).collect()

//    priorityDF.collect()(0).getString(1)

    import sqlContext.implicits._
    // 测试数据
    val seq = List(
      ("a", "value1", "", "2017-11-05", "X0100013", "value8"),
      ("a", "value2", "value3", "2017-11-07", "X0100059", "value9"),
      ("b", "value4", "", "2017-11-19", "Z0100030", "value10"),
      ("b", "value5", "", "2017-11-20", "Z0100030", "value11"),
      ("b", "value6", "value7", "2017-11-10", "X0100059", "value12"))

    val dataFrame = seq.toDF("column1", "column2", "column3", "createTime", "retailerid", "column4")
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")

    // 将数据表数据映射成(key, columns(通过connectStr连接) + 时间字段索引 + 字段主键ID索引)
    val mappedRdd = dataFrame.rdd.map(item => {
      val createTimeIndex = item.fieldIndex("createTime")
      val retaileridIndex = item.fieldIndex("retailerid")
      val splitsed = item.mkString(connectStr).split(connectStr)
      (splitsed(0), item.mkString(connectStr) + connectStr + createTimeIndex + connectStr + retaileridIndex)
    })

    val keyStringRDD = mappedRdd.reduceByKey((item1, item2) => {

      val itemSplit1 = item1.split(connectStr)
      val itemSplit2 = item2.split(connectStr)

      val item1Length = itemSplit1.length
      val item2Length = itemSplit2.length
      // 获取最大字段数
      val maxd = math.max(item1Length, item2Length)

      // 获取最后一个split索引值
      val lastIndexStr1 = itemSplit1.last
      val lastIndexStr2 = itemSplit2.last

      // 获取倒2个记录索引
      val dateIndexStr1 = itemSplit1(itemSplit1.length - 2)
      val dateIndexStr2 = itemSplit2(itemSplit2.length - 2)

      // 获取倒1个记录索引值
      val date1Str = itemSplit1(dateIndexStr1.toInt)
      val date2Str = itemSplit2(dateIndexStr2.toInt)

      // 获取倒2个记录索引值
      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)

      val item1Retailerid = itemSplit1(lastIndexStr1.toInt) // 站点id
      val item2Retailerid = itemSplit2(lastIndexStr2.toInt)

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
        val itemValue1 = itemSplit1(i)
        val itemValue2 = itemSplit2(i)
        if (!itemValue1.equalsIgnoreCase(itemValue2)) {
          if (itemValue1 == "" || itemValue2 == "" || itemValue1.equalsIgnoreCase("NULL") || itemValue2.equalsIgnoreCase("NULL")) {
            if (itemValue1.equalsIgnoreCase("NULL")) {
              result += itemValue2 + connectStr
            } else if (itemValue2.equalsIgnoreCase("NULL")) {
              result += itemValue1 + connectStr
            } else {
              result += (itemValue1 + itemValue2) + connectStr
            }
          } else {
            result = createResultContent(priority1, priority2, nowTime, item1ExpireTime, item2ExpireTime, result, itemValue1, itemValue2)
          }
        } else {
          result = createResultContent(priority1, priority2, nowTime, item1ExpireTime, item2ExpireTime, result, itemValue1, itemValue2)
        }
      }
      if (result.endsWith(connectStr)) {
        result = result.substring(0, result.length - 3)
      }
      result
    })

    val valueRDDs = keyStringRDD.map(item => {
      val splits = item._2.split(connectStr)
      println(splits.mkString("     "))
      val columnBean = createTableBean(splits.length, splits)
      columnBean
    })

    sqlContext.createDataFrame(valueRDDs, dataFrame.schema).show()

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
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5))
        columnBean

      case 6 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3))
        columnBean

    }
  }

}
