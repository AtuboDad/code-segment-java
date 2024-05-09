package com.mundo.etl.spark.postgres

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  测试连接postgres
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-06
  */
object ConnectPostgresSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("ConnectPostgresSuite")
    val sc = new SparkContext(conf)

    val sql = new SQLContext(sc)

    val df = sql.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1_riviews")
      .option("dbtable", "cp_param")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    df.show(10)
    sc.stop()

  }

}
