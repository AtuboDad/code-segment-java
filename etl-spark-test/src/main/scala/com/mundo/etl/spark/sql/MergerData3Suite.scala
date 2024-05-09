package com.mundo.etl.spark.sql

import java.text.SimpleDateFormat

import org.apache.spark.sql.{Row, RowFactory, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  合并数据测试
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object MergerData3Suite {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerData2Suite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    import sqlContext.implicits._
    val seq = List(
      ("a", "test1111", "", "2017-12-05", "dasdad"),
      ("a", "", "test2222", "2017-12-07", "dasdad"),
      ("b", "test4444", "", "2017-12-09", "dasdad"),
      ("b", "test3333", "", "2017-12-07", "dasdad"),
      ("b", "test5555", "test6666", "2017-12-05", "dasdad"))

    val dataFrame = seq.toDF("colmun1", "colmun2", "colmun3", "createTime", "column4")
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd")

    val mappedRdd = dataFrame.rdd.map(item => {
      val createTimeIndex = item.fieldIndex("createTime")
      val splitsed = item.mkString(connectStr).split(connectStr)
      (splitsed(0), item.mkString(connectStr) + connectStr + createTimeIndex)
    })

    val keyStringRDD = mappedRdd.reduceByKey((item1, item2) => {

      val itemSplit1 = item1.split(connectStr)
      val itemSplit2 = item2.split(connectStr)

      val item1Length = itemSplit1.length
      val item2Length = itemSplit2.length
      val maxd = math.max(item1Length, item2Length) // 获取最大字段

      val lastIndexStr1 = itemSplit1.last
      val lastIndexStr2 = itemSplit2.last

      println("item1Length : " + item1 + " :: " + item1Length + " || " + "item2Length : " + item2 + " :: " + item2Length)

      val date1Str = itemSplit1(lastIndexStr1.toInt)
      val date2Str = itemSplit2(lastIndexStr2.toInt)

      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)

      var result = ""
      for (i <- 0 until maxd) {
        val itemValue1 = itemSplit1(i)
        val itemValue2 = itemSplit2(i)
        if (!itemValue1.equalsIgnoreCase(itemValue2)) {
          if (itemValue1 == "" || itemValue2 == "") {
            result += (itemValue1 + itemValue2) + connectStr
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
      if (result.endsWith(connectStr)) {
        result = result.substring(0, result.length - 3)
      }
      result
    })

    val valueRDDs = keyStringRDD.map(item => {
      val splits = item._2.split(connectStr)
      val columnBean = createTableBean(splits)
      columnBean
    })

    sqlContext.createDataFrame(valueRDDs, dataFrame.schema).show()

    sc.stop()

  }

  def createTableBean(splits: Array[String]): Row = {
      val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3))
    columnBean
  }

  case class ColumnBean(str: String, str1: String, str2: String, str3: String)

}
