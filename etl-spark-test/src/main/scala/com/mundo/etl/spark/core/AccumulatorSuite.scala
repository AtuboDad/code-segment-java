package com.mundo.etl.spark.core

import org.apache.spark.sql.SparkSession

object AccumulatorSuite {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("AccumulatorSuite").master("local[2]").getOrCreate()
    val sc = spark.sparkContext
    val data = Array(1, 2, 3, 4, 5)
    // 定义累加器
    val accum = sc.longAccumulator("My Accumulator")
    sc.parallelize(data).foreach(x => accum.add(x))
    // 获取累加器的值
    println(accum.value)

    // 把一个数组定义为一个广播变量
    val broadcastVar = sc.broadcast(Array(1, 2, 3, 4, 5))
    // 之后用到该数组时应优先使用广播变量，而不是原值
    sc.parallelize(broadcastVar.value).map(_ * 10).collect()
  }

}
