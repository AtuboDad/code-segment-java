package com.mundo.etl.spark.hive

import java.text.SimpleDateFormat

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
import org.slf4j.LoggerFactory

/**
  * Description:  测试合并Hive表数据，在Hive中测试的版本，将合并数据保存至Hive表中，
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object MergerDataIntoHiveTable5 {

  private val logger = LoggerFactory.getLogger("MergerDataIntoHiveTable5")

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

    val conf = new SparkConf().setAppName("MergerDataIntoHiveTable5")
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

        (keyIndexItemResult, (item, retaileridIndex))
      } else {
        (item.getString(keyIndex), (item, retaileridIndex))
      }
    })

    val reduceRDD = mappedRdd.map(item1 => {

      val retaileridIndex1 = item1._2._2
      val item1Retailerid = item1._2._1.getString(retaileridIndex1)

      var collectItemStr1 = "NULL"
      // 通过策略表信息，过去站点对应的优先级以及过期时间天数
      if (policyCollect.mkString(",").contains(item1Retailerid)) {
        for (collectItem <- policyCollect) {
          if (collectItem.contains(item1Retailerid) || collectItem.startsWith(item1Retailerid)) {
            collectItemStr1 = collectItem
          }
        }
      }

      collectItemStr1.split(connectStr)(1)
    })

    val distinct = reduceRDD.distinct()
    logger.info(distinct.collect().mkString(" | "))

    // 合并数据
    sc.stop()

  }

}
