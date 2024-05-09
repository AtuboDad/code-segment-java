package com.mundo.etl.spark.sql

import java.text.SimpleDateFormat

import org.apache.spark.sql.{RowFactory, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  合并数据，测试最后一个字段为空
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object MergerData4_1Suite {
  
  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerData4_1Suite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._
    val seq = List(
      ("a", "test1111", "", "2017-12-05 12:12:45", ""),
      ("a", "", "test2222", "2017-12-07 12:12:45", ""),
      ("b", "test3333", "", "2017-12-07 12:12:45", ""),
      ("b", "test5555", "test6666", "2017-12-05 12:12:45", "test"))

    val dataFrame = seq.toDF("colmun1", "colmun2", "colmun3", "createTime", "column4")
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val mappedRdd = dataFrame.rdd.map(item => {
      val splitsed = item.toString().substring(1, item.toString().length - 1).split(",")
      (splitsed(0), item)
    })

    mappedRdd.reduceByKey((item1, item2) => {

      val item1Length = item1.length
      val item2Length = item2.length
      val maxd = math.max(item1Length, item2Length) // 获取最大字段
      val date1Str = item1.getString(3)
      val date2Str = item2.getString(3)
      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)

      var result = ""
      for (i <- 0 until maxd) {
        val itemValue1 = String.valueOf(item1.get(i))
        val itemValue2 = String.valueOf(item2.get(i))
        if (!itemValue1.equalsIgnoreCase(itemValue2)) {
          if (itemValue1 == "" || itemValue2 == "") {
            result += itemValue1 + itemValue2 + connectStr
          } else {
            if (date1.getTime > date2.getTime) {
              result += itemValue1 + connectStr
            } else {
              result += itemValue2 + connectStr
            }
          }
        } else {
          result += itemValue1 + connectStr
        }
      }
      val splitsed = result.split(connectStr)
      println("splitsed.length : " + splitsed.length)
      val row = RowFactory.create(splitsed(0), splitsed(1), splitsed(2), splitsed(3)) // Row 无法动态增长
      row
    }).map(_._2).map(item => {
      val str1 = item.getString(0)
      val str2 = item.getString(1)
      val str3 = item.getString(2)
      val str4 = item.getString(3)
      (str1, str2, str3, str4)
    }).toDF().registerTempTable("mergerData2Suite")

    sqlContext.sql("select * from mergerData2Suite").show()

    sc.stop()

  }

}
