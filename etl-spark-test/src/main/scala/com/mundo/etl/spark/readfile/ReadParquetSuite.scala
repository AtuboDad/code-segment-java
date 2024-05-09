package com.mundo.etl.spark.readfile

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  读取parquet格式化数据
  * Author: 赖传剑
  * Version: 1.0.
  * Date: 2017-12-07
  */
object ReadParquetSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("ReadParquetSuite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val df = sqlContext.read.parquet("C:/workspaces/ideaspaces/onlyou-cdh-spark/data/users.parquet")
//    println(df.asInstanceOf[AnyRef].getClass.getSimpleName)
    df.count() // NullPointerException

    sc.stop()
  }

}
