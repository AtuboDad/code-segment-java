package com.mundo.etl.spark.postgres

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object ReadDataFromPostgresSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("ReadDataFromPostgresSuite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val df = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    val dataDf = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy_data")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    df.show()
    dataDf.show()
    val groupByRdd = dataDf.rdd.map(item => {
      val splited = item.toString().substring(1, item.toString().length - 1).trim.split(",")
      (splited(0).trim, (splited(1).trim, splited(2).trim, splited(3).trim, splited(4).trim, splited(5).trim, splited(6).trim, splited(7).trim))
    }).groupByKey()

    df.registerTempTable("site_priority_policy")

    val siteRdd = sqlContext.sql("select retailerid,priority,validity from site_priority_policy").rdd

    groupByRdd.map(item => {
      val key = item._1
      val values = item._2
      (key, values)
    }).foreach(println)

    sc.stop()

  }

}
