package com.mundo.etl.spark.hive

import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  测试合并f_trademark_info表数据，不完整版本，没有根据策略表条件控制
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object MergerTrademarkInfoSuite {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    if (args.length < 2) {
      println("Usage: MergerTrademarkInfoSuite <master> <output_dir> [table_name] [key]")
      System.exit(1)
    }

    val conf = new SparkConf().setAppName("MergerTrademarkInfoSuite")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)

    val key = "trademark_reg_no"
    var keyIndex = -1
    // edw.f_trademark_info
    val dataFrame = sqlContext.sql("select * from " + args(0) +"  where trademark_reg_no='5897612'")

    for (i <- dataFrame.columns.indices) {
      val item = dataFrame.columns(i)
      if (key.equalsIgnoreCase(item)) {
        keyIndex = i
      }
    }

    if (keyIndex == -1) {
      return
    }

    val mappedRdd = dataFrame.rdd.map(item => {
      val splitsed = item.mkString(connectStr).split(connectStr)
      (splitsed(keyIndex), item.mkString(connectStr))
    })

    val keyStringRDD = mappedRdd.reduceByKey((item1, item2) => {

      val itemSplit1 = item1.split(",")
      val itemSplit2 = item2.split(",")
      val item1Length = itemSplit1.length
      val item2Length = itemSplit2.length
      // 获取最大字段
      val maxd = math.max(item1Length, item2Length)

      var result = ""
      for (i <- 0 until maxd) {
        val itemValue1 = itemSplit1(i)
        val itemValue2 = itemSplit2(i)
        if (!itemValue1.equalsIgnoreCase(itemValue2)) {
          if (itemValue1.trim == "" || itemValue2.trim == "" || itemValue1.equalsIgnoreCase("NULL") || itemValue2.equalsIgnoreCase("NULL")) {
            if (itemValue1.equalsIgnoreCase("NULL")) {
              result += itemValue2 + connectStr
            } else if (itemValue2.equalsIgnoreCase("NULL")) {
              result += itemValue1 + connectStr
            } else {
              result += (itemValue1 + itemValue2) + connectStr
            }
          } else {
              result += itemValue2 + connectStr
          }
        } else {
          result += itemValue1 + connectStr
        }
      }
      result
    })

    val valueRDDs = keyStringRDD.map(item => {
      val splits = item._2.split(connectStr)
      val columnBean = CreateRowUtil.createRow(splits.length, splits)
      columnBean
    })

    sqlContext.createDataFrame(valueRDDs, dataFrame.schema).show()

    sc.stop()

  }

}
