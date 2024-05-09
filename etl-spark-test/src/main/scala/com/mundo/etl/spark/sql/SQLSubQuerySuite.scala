package com.mundo.etl.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-13
  */
object SQLSubQuerySuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SQLSubQuerySuite").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val dbDF = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    dbDF.registerTempTable("site_priority_policy")
    val df = sqlContext.sql("select count(1) from (select * from site_priority_policy)t")
    df.show()

    sc.stop()
  }

}
