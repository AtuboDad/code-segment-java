package com.mundo.etl.spark.readfile

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  读取Json格式化文件数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-07
  */
object ReadJsonSuite {

  def main(args: Array[String]): Unit = {

//    val conf = new SparkConf().setAppName("ReadJsonSuite").setMaster("local[2]")
//    val sc = new SparkContext(conf)
//    val sqlContext = new SQLContext(sc)
    val session = SparkSession.builder().master("local[2]").appName("ReadJsonSuite").getOrCreate()

    val dataFrame = session.read.format("json").load("/home/master/workspaces/selfspaces/work-apache-project/data/people.json")
    dataFrame.show()

    session.stop()
  }
}
