package com.mundo.etl.spark.hive

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.LoggerFactory

/**
  * Description:  测试合并Hive表数据，在Hive中测试的版本，将合并数据保存至Hive表中，
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object MergerDataIntoHiveTable4 {

  private val logger = LoggerFactory.getLogger("MergerDataIntoHiveTable4")

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    if (args.length < 1) {
      println("Usage: spark-submit \\")
      println("       --executor-memory 256M \\")
      println("       --driver-memory 256M \\")
      println("       --class com.mundo.etl.spark.hive.MergerDataIntoHiveTable \\")
      println("       --master yarn --deploy-mode cluster \\")
      println("       <dir>/etl-spark-1.0-SNAPSHOT.jar [table_name] ")
      println("")
      println("       like: ")
      println("            table_name: edw.f_trademark_info")
      System.exit(0)
    }

    val conf = new SparkConf().setAppName("MergerDataIntoHiveTable4")
    // 初始化SparkContext
    val sc = new SparkContext(conf)
    //  初始化HiveContext
    val sqlContext = new HiveContext(sc)
    import sqlContext.implicits._

    // 数据表中的Primary key的索引
    var keyIndex = -1
    var keyIndexs = ""
    // 通过数据维度查询站点信息
    val policyDF = sqlContext.sql("select * from edw.site_priority_policy where dimension ='" + args(0) + "' order by priority")
    //    sqlContext.sql("DROP TABLE IF EXISTS " + args(0) + "_sparksql")
    if (policyDF.collect().length <= 0) {
      println("Error message: It's not exist this primary key.")
      System.exit(0)
    }
    // 策略表中的Primary key
    val key = policyDF.collect()(0).getString(1)
    if (key.trim.length <= 0 || key.equalsIgnoreCase("")) {
      println("Error message: There is not value of primary key.")
      System.exit(0)
    }
    logger.info("Primary key : " + key)

    // 查询站点ID, 优先级, 过期时间
    val policyCollect = policyDF.select("retailerid", "priority", "validity").map(row => {
      val retailerid = row.getString(0)
      val priority = row.getString(1)
      val validity = row.getString(2)
      val result = retailerid + connectStr + priority + connectStr + validity + connectStr
      result
    }).collect()

    // 查询数据
    val dataFrame = sqlContext.sql("select * from " + args(0))
    val dateFormat = new SimpleDateFormat("yyyyMMdd")

    // Primary key在数据表中的索引
    if (key.contains(",")) {
      val keys = key.split(",")
      for (i <- dataFrame.columns.indices) {
        val item = dataFrame.columns(i)
        for (keyItem <- keys) {
          if (keyItem.equalsIgnoreCase(item)) {
            keyIndexs += i + "_"
          }
        }
      }
      keyIndexs = keyIndexs.substring(0, keyIndexs.length - 1)
    } else {
      for (i <- dataFrame.columns.indices) {
        val item = dataFrame.columns(i)
        if (key.equalsIgnoreCase(item)) {
          keyIndex = i
        }
      }
    }

    if (key.contains(",")) {
      if (keyIndexs == "") {
        println("Error message: There is not primary key, check it please.")
        System.exit(0)
      }
    } else {
      if (keyIndex == -1) {
        println("Error message: There is not primary key, check it please.")
        System.exit(0)
      }
    }

    logger.info("Primary key index: " + keyIndex)
    logger.info("Primary key indexs: " + keyIndexs)

    // 将数据表数据映射成(key, columns(通过connectStr连接) + 时间索引 + 站点ID索引)
    val mappedRdd = dataFrame.rdd.map(item => {
      // 获取时间字段索引
      val bizdateIndex = item.fieldIndex("bizdate")
      // 获取站点字段索引
      val retaileridIndex = item.fieldIndex("retailerid")

      if (key.contains(",")) {
        val keyIndexItems = keyIndexs.split("_")
        var keyIndexItemResult = ""
        for (keyIndexItem <- keyIndexItems) {
          val keyIndexItemInt = keyIndexItem.toInt
          keyIndexItemResult += item.getString(keyIndexItemInt)
        }

        (keyIndexItemResult, (item, bizdateIndex, retaileridIndex))
      } else {
        (item.getString(keyIndex), (item, bizdateIndex, retaileridIndex))
      }
    })

    logger.info(mappedRdd.filter(item => {
      val retaileridIndex = item._2._3
      !"X0100047-X0100059-X0100023-X0100075-Z0100056-X0100018-X0100061-Z0100030-X0100049".contains(item._2._1.getString(retaileridIndex))
    }).take(10).mkString("  |   "))

    // 合并数据
    val keyStringRDD = mappedRdd.reduceByKey((item1, item2) => {

      // 获取最大字段
      val maxd = math.max(item1._1.size, item2._1.size)

      val bizdateIndex1 = item1._2
      val bizdateIndex2 = item2._2
      val retaileridIndex1 = item1._3
      val retaileridIndex2 = item2._3

      // 获取倒2个记录索引值
      var date1Str = item1._1.getString(bizdateIndex1)
      var date2Str = item2._1.getString(bizdateIndex2)
      // 转化成时间格式
      if (date1Str.trim == "" || date1Str.equalsIgnoreCase("NULL")) {
        date1Str = "20161212"
      }
      if (date2Str.trim == "" || date2Str.equalsIgnoreCase("NULL")) {
        date2Str = "20161212"
      }

      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)

      val item1Retailerid = item1._1.getString(retaileridIndex1)
      val item2Retailerid = item2._1.getString(retaileridIndex2)

      var conditionStr1 = ""
      var conditionStr2 = ""

      // 通过策略表信息，过去站点对应的优先级以及过期时间天数
      for (collectItem <- policyCollect) {
        if (collectItem.contains(item1Retailerid.trim)) {
          conditionStr1 = collectItem
        }
        if (collectItem.contains(item2Retailerid.trim)) {
          conditionStr2 = collectItem
        }
      }

      val condition1Splits = conditionStr1.split(connectStr)
      val condition2Splits = conditionStr2.split(connectStr)
      // 获取优先级
      val priority1 = condition1Splits(1).toInt
      // 获取过期时间天数
      val validity1 = condition1Splits(2).toInt

      // 获取优先级
      val priority2 = condition2Splits(1).toInt
      // 获取过期时间天数
      val validity2 = condition2Splits(2).toInt

      // 获取当前时间、加上过期时间天数的数据记录时间
      val calendar = Calendar.getInstance()
      val nowTime = calendar.getTime

      calendar.setTime(date1)
      calendar.add(Calendar.DATE, validity1)
      val item1ExpireTime = calendar.getTime
      calendar.setTime(date2)
      calendar.add(Calendar.DATE, validity2)
      val item2ExpireTime = calendar.getTime

      // 遍历每一个数据项，对数据进行合并
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
      if (result.endsWith(connectStr)) {
        result = result.substring(0, result.length - 3)
      }
      val resultSplits = result.split(connectStr)
      val columnBean = CreateRowUtil.createRow(maxd, resultSplits)
      (columnBean, item1._2, item1._3)
    })

    // 创建数据记录
    val valueRDDs = keyStringRDD.map(_._2._1)

    // 保存至Hive表中
    val resultDF = sqlContext.createDataFrame(valueRDDs, dataFrame.schema)
    //    resultDF.write.saveAsTable(args(0) + "_sparksql")
    resultDF.write.mode(SaveMode.Overwrite).saveAsTable(args(0) + "_sparksql")

    sc.stop()

  }

  private def createResultContent(priority1: Int, priority2: Int, nowTime: Date, item1ExpireTime: Date, item2ExpireTime: Date, src: String, itemValue1: String, itemValue2: String) = {
    var result = src
    // priority1优先级高
    if (priority1 <= priority2) {
      if (priority1 == priority2) {
        if (item1ExpireTime.getTime < item2ExpireTime.getTime) {
          result += itemValue2 + connectStr
        } else {
          result += itemValue1 + connectStr
        }
      } else {
        // 记录1时间过期, 记录2时间未过期, 取记录2中的值
        if (item1ExpireTime.getTime < nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime) {
          result += itemValue2 + connectStr
        } else {
          result += itemValue1 + connectStr
        }
      }
    } else {
      if (item2ExpireTime.getTime < nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime) {
        result += itemValue1 + connectStr
      } else {
        result += itemValue2 + connectStr
      }
    }
    result
  }

}
