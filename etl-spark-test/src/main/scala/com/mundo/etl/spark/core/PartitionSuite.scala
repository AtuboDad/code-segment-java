package com.mundo.etl.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  重分区测试
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-03
  */
object PartitionSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("PartitionSuite")
    val sc = new SparkContext(conf)

    val n = 200000
    val composite = sc.parallelize(2 to n, 8).map(x => (x, (2 to (n / x)))).flatMap(kv => kv._2.map(_ * kv._1))
    val prime = sc.parallelize(2 to n, 8).subtract(composite)
    prime.collect()

    sc.stop()

  }

}
