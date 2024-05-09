package com.mundo.etl.spark.core

import java.util
import java.util.Arrays

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object ReduceAndGroupSuite {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("ReduceAndGroupSuite").master("local[2]").getOrCreate()
    val sc = spark.sparkContext
    val rdd1 = sc.parallelize(List(("spark", 1), ("hadoop", 1), ("spark", 2), ("hive", 2), ("flink", 2)), 2)
    val rdd2 = sc.parallelize(List(("spark", 3), ("hive", 3), ("hadoop", 4)), 2)
    val value1: RDD[(String, (Int, Int))] = rdd1.join(rdd2)
    val repartition1 = value1.repartition(2).mapPartitions(partition => {
      partition
    })

    repartition1.foreach(println)
    println("111111111111111111111111111111111111")

    val repartition2 = value1.repartition(2).map(partition => {
      partition
    })
    repartition2.foreach(println)

  }

}
