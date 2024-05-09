package com.mundo.etl.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  读取HDFS文件内容
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-06
  */
object ReadHdfsWordCountSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setAppName("ReadHdfsWordCount").setMaster("local[2]")

    val sc = new SparkContext(conf)

    val lines = sc.textFile("hdfs://192.168.88.61:8020/flink/README.txt")
    val linesFlatMap = lines.flatMap(_.split(" "))
    val reduce = linesFlatMap.map((_, 1)).reduceByKey(_ + _)
    reduce.foreach(println)
    sc.stop()

  }

}
