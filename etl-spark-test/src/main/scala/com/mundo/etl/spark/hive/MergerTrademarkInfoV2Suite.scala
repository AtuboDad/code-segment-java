package com.mundo.etl.spark.hive

import java.text.SimpleDateFormat
import java.util.Calendar

import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import com.mundo.etl.spark.utils.CreateRowUtil
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.LoggerFactory

/**
  * Description:  测试合并f_trademark_info表数据，在Hive中的测试版本，显示数据，可查看最终版 MergerDataIntoHiveTable
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  * @see com.mundo.etl.spark.hive.MergerDataIntoHiveTable
  */
object MergerTrademarkInfoV2Suite {

  private val  logger = LoggerFactory.getLogger("MergerTrademarkInfoV2Suite")

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    if (args.length < 2) {
      println("Usage: MergerTrademarkInfoSuite <master> <output_dir> [table_name] [key]")
      System.exit(1)
    }

    val conf = new SparkConf().setAppName("MergerTrademarkInfoSuite")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)
    import sqlContext.implicits._

    val key = "trademark_reg_no"
    var keyIndex = -1
    // edw.f_trademark_info
    val policyDF = sqlContext.sql("select * from edw.site_priority_policy order by priority")
    val policyCollect = policyDF.select("retailerid", "priority", "validity").map(row => {
      val retailerid = row.getString(0)
      val priority = row.getString(1)
      val validity = row.getString(2)
      val result = retailerid + connectStr + priority + connectStr + validity
      result
    }).collect()


    val dataFrame = sqlContext.sql("select * from " + args(0) + "  where trademark_reg_no='5897612'")
    val dateFormat = new SimpleDateFormat("yyyyMMdd")

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
      val bizdateIndex = item.fieldIndex("bizdate") // 获取时间字段索引
      val retaileridIndex = item.fieldIndex("retailerid") // 获取站点字段索引
      val splitsed = item.mkString(connectStr).split(connectStr)
      (splitsed(keyIndex), item.mkString(connectStr) + connectStr + bizdateIndex + connectStr + retaileridIndex)
    })

    logger.info(mappedRdd.collect().mkString(","))

    val keyStringRDD = mappedRdd.reduceByKey((item1, item2) => {

      val itemSplit1 = item1.split(connectStr)
      val itemSplit2 = item2.split(connectStr)
      val item1Length = itemSplit1.length
      val item2Length = itemSplit2.length

      val maxd = math.max(item1Length, item2Length) // 获取最大字段

      val lastIndexStr1 = itemSplit1.last // 获取时间字段索引
      val lastIndexStr2 = itemSplit2.last

      val dateIndexStr1 = itemSplit1(itemSplit1.length - 2)
      val dateIndexStr2 = itemSplit2(itemSplit2.length - 2)

      val item1Bizdate = itemSplit1(dateIndexStr1.toInt) // 获取时间字段值
      val item2Bizdate = itemSplit2(dateIndexStr2.toInt)

      val item1Retailerid = itemSplit1(lastIndexStr1.toInt) // 获取站点字段值
      val item2Retailerid = itemSplit2(lastIndexStr2.toInt)

      val date1 = dateFormat.parse(item1Bizdate) // 转化成时间格式
      val date2 = dateFormat.parse(item2Bizdate)

      var conditionStr1 = ""
      var conditionStr2 = ""

      for (collectItem <- policyCollect) {
        if (collectItem.contains(item1Retailerid)) {
          conditionStr1 = collectItem
        }
        if (collectItem.contains(item2Retailerid)) {
          conditionStr2 = collectItem
        }
      }

      val condition1Splits = conditionStr1.split(connectStr)
      val condition2Splits = conditionStr2.split(connectStr)

      val priority1 = condition1Splits(1).toInt
      val validity1 = condition1Splits(2).toInt
      val priority2 = condition2Splits(1).toInt
      val validity2 = condition2Splits(2).toInt

      val calendar = Calendar.getInstance()
      val nowTime = calendar.getTime
      calendar.setTime(date1)
      calendar.add(Calendar.DATE, validity1)
      val item1ExpireTime = calendar.getTime
      calendar.setTime(date2)
      calendar.add(Calendar.DATE, validity2)
      val item2ExpireTime = calendar.getTime

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
            if (priority1 < priority2) { // priority1优先级高
              if (item1ExpireTime.getTime < nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime) {
                result += itemValue2 + connectStr
              } else {
                result += itemValue1 + connectStr
              }
            } else {
              if (item2ExpireTime.getTime < nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime) {
                result += itemValue1 + connectStr
              } else {
                result += itemValue2 + connectStr
              }
            }
          }
        } else {
          if (priority1 < priority2) { // priority1优先级高
            if (item1ExpireTime.getTime < nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime) {
              result += itemValue2 + connectStr
            } else {
              result += itemValue1 + connectStr
            }
          } else {
            if (item2ExpireTime.getTime < nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime) {
              result += itemValue1 + connectStr
            } else {
              result += itemValue2 + connectStr
            }
          }
        }
      }

      if (result.endsWith(connectStr)) {
        result = result.substring(0, result.length - 3)
      }
      result
    })

    val valueRDDs = keyStringRDD.map(item => {
      val splits = item._2.split(connectStr)
      val columnBean = CreateRowUtil.createRow(splits.length - 2, splits)
      columnBean
    })

    sqlContext.createDataFrame(valueRDDs, dataFrame.schema).show()

    sc.stop()

  }

}
