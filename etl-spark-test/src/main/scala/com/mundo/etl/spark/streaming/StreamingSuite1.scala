package com.mundo.etl.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-02
  */
object StreamingSuite1 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("StreamingSuite1").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(3))

    val line = ssc.socketTextStream("172.16.123.80", 9999)
    val words = line.flatMap(_.split(" "))

    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)


    wordCounts.print()
    ssc.start()             // Start the computation
    ssc.awaitTermination()  // Wait for the computation to terminate

  }

}
