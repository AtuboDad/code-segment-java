package com.mundo.etl.spark.core

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  简单RDD测试
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-04
  */
object SimpleSuite {

  def main(args: Array[String]): Unit = {

//    val conf = new SparkConf().setMaster("local[2]").setAppName("SimpleTest1")
//    val sc = new SparkContext(conf)

    val session = SparkSession.builder().master("local[2]").appName("SimpleTest1").getOrCreate()

    val data = Array(1, 2, 3, 4, 5)
    val distData = session.sparkContext.parallelize(data)

    println(distData)

//    sc.stop()
    session.stop()
  }

}
