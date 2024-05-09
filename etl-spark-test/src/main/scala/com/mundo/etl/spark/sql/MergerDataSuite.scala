package com.mundo.etl.spark.sql

import org.apache.spark.sql.{Row, RowFactory, SQLContext}
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Description:  测试数据合并，创建StructType方式
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-06
  */
object MergerDataSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerDataSuite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._
    import org.apache.spark.sql.functions._
    val seq = Seq(("1", "101", "2001"), ("1", "", "2002"), ("2", "202", "2003"), ("2", "302", "2004"))

    val rows = ListBuffer[Row]()
    val random = new Random()
    var k_tmp = -1

    for (k <- 0 to 4) {
      var id: String = (random.nextInt(2) + 1).toString
      var num1: String = random.nextInt(500).toString
      if (id == "1" && k > k_tmp) {
        k_tmp = 99
      } else {
        if (id == "1") {
          num1 = ""
        }
      }
      var num2: String = random.nextInt(5000).toString
      val row = RowFactory.create(id, num1, num2)
      rows += row
    }

    val schema = DataTypes.createStructType(java.util.Arrays.asList(
      DataTypes.createStructField("id", DataTypes.StringType, true),
      DataTypes.createStructField("num1", DataTypes.StringType, true),
      DataTypes.createStructField("num2", DataTypes.StringType, true)))

//    val df = sparkSession.createDataFrame(rowRDD, schema)
//    df.createOrReplaceTempView("user_visit_action")

    val rowRDD = sc.parallelize(rows.toList)
    val df = sqlContext.createDataFrame(rowRDD, schema)
    df.show()

    df.registerTempTable("tmp_test_table")
    sqlContext.sql("select id,num1 from tmp_test_table where num1<>''").show()
    df.groupBy("id").agg('id, max('num1), min('num2)).show()

    sc.stop()

  }

}
