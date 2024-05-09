package com.mundo.etl.spark.hive

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.{Logger, LoggerFactory}

/**
  * Description:  测试读取hive表数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-07
  */
object SparkSQLReadHiveSuite {

  def main(args: Array[String]): Unit = {

    val logger = LoggerFactory.getLogger("SparkSQLReadHiveSuite")

    val conf = new SparkConf()
    conf.setAppName("SparkSQLReadHive")

    val sc = new SparkContext(conf)

    val hiveContext = new HiveContext(sc)

    val dataFrame = hiveContext.sql("select * from edw.site_priority_policy")
    dataFrame.collect().foreach(println)

    sc.stop()

  }

}
