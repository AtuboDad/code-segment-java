package com.mundo.etl.spark.scala

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-22
  */
object ReadDataToMapSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("ReadDataToMapSuite")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    val file = sc.textFile("C:\\workspaces\\ideaspaces\\onlyou-cdh-spark\\data\\to_map_content.txt")
    val mappedRDD = file.map(item => {
      val splitResults = item.split(":")
      splitResults(0) -> splitResults(1)
    })
    val mapResult = mappedRDD.collect().toMap
    val option = mapResult.get("table_name1")
    println(option)

    sc.stop()
  }

}
