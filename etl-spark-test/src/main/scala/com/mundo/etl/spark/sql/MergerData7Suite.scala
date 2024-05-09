package com.mundo.etl.spark.sql

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import org.apache.spark.sql.{Row, RowFactory, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  本地测试合并数据，完整版
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object MergerData7Suite {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerData5Suite").setMaster("local[2]")
    // 初始化SparkContext
    val sc = new SparkContext(conf)
    // 初始化SQLContext
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val dbDF = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    dbDF.registerTempTable("site_priority_policy")
    val priorityDF = sqlContext.sql("select * from site_priority_policy where dimension='edw.f_software_copyright_info' order by priority")
    val policyCollect = priorityDF.select("retailerid", "priority", "validity").map(row => {
      val retailerid = row.getString(0)
      val priority = row.getString(1)
      val validity = row.getString(2)
      val result = retailerid + connectStr + priority + connectStr + validity + connectStr
      result
    }).collect()

//    priorityDF.collect()(0).getString(1)

    import sqlContext.implicits._
    // 测试数据
    val seq = List(
      ("d41d8cd98f00b204e9800998ecf8427e","2017SR144835","10100-0000","易景（EGIN）企业之家信息管理系统","","V1.0","厦门易景软件工程有限公司","350298200010623","9135020069303785X6","福建","2017-04-27","2016-09-01","20171215","02qixinwang","park_0099_厦门易景软件工程有限公司","厦门易景软件工程有限公司","X0100075","","d41d8cd98f00b204e9800998ecf8427e","1C1B6UCQ1GMD080C14AC000025E436FC","9135020069303785X6"),
      ("9c1a268ad3e32dbcadcffd31545795d7","2017SR144835","10100-0000","易景（EGIN）企业之家信息管理系统","","V1.0","厦门易景软件工程有限公司","350298200010623","9135020069303785X6","福建","2016-09-01","2017-04-27","20170921","05ccopyright","厦门易景软件工程有限公司","厦门易景软件工程有限公司","X0100061","","9c1a268ad3e32dbcadcffd31545795d7","1BQHMMR7AH2P040C14AC000004DA32DE","9135020069303785X6"),
      ("","2014SR089745","30200-8400","国际货运及代理实训基地教学软件","国际货运及代理实训基地","V2.0","广州市东洋科技有限公司","","","","2014-07-02","2013-09-15","20161125","02qixinwang","org_qxw_rjzzq_20161123_10180","广州市东洋科技有限公司","X0100018","","","1B28AV1RABVS9A0C14AC000023353C6F",""),
      ("","2014SR089745","30200-8400","国际货运及代理实训基地教学软件","国际货运及代理实训基地","V2.0","广州市东洋科技有限公司","","","","2013-09-15","2014-07-02","20160220","01rjzzq","zhuzuoquan_20150219_1614","广州市东洋科技有限公司","Z0100056","","","1ABS9TREOK2B0A0C14AC0000AE56A912",""),
      ("","2013SR133453","30200-0000","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","350211200049114","91350213575026949M","福建","2012-09-05","2013-11-27","20160310","01rjzzq","zhuzuoquan_20150219_1808","厦门仟信德电子科技有限公司","Z0100056","","","1ADEBIRMT4D8020C14AC0000F0066B22","91350213575026949M"),
      ("","2013SR133453","30200-0000","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","350211200049114","91350213575026949M","福建","2013-11-27","2012-09-05","20161122","02qixinwang","org_qxw_rjzzq_1111_20161116_20251","厦门仟信德电子科技有限公司","X0100018","","","1B242HUC85AF040C14AC0000E2DF778A","91350213575026949M"),
      ("d41d8cd98f00b204e9800998ecf8427e","2013SR133453","30200-0000","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","","91350213575026949M","福建","2013-11-27","2012-09-05","20171220","02qixinwang","park_0099_厦门仟信德电子科技有限公司","厦门仟信德电子科技有限公司","X0100075","","d41d8cd98f00b204e9800998ecf8427e","1C1NO7346SAL970C14AC0000D15F10F3","91350213575026949M"),
      ("d41d8cd98f00b204e9800998ecf8427e","2013SR133453","","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","350211200049114","91350213575026949M","福建","","2013-11-27","20170323","03kaimaile","X0100047_20170323_0003_北京凯迈乐知识产权_软件著作权查询_厦门仟信德电子科技有限公司","厦门仟信德电子科技有限公司","X0100047","","d41d8cd98f00b204e9800998ecf8427e","1BBSJBDOHRH5980C14AC00005D89EBF2","91350213575026949M"),
      ("65a97ad70469158ffdd181211492d263","2013SR133453","30200-0000","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","350211200049114","91350213575026949M","福建","2012-09-05","2013-11-27","20171024","05ccopyright","厦门仟信德电子科技有限公司","厦门仟信德电子科技有限公司","X0100061","","65a97ad70469158ffdd181211492d263","1BT6HD14J93K980C14AC000017AD8A10","91350213575026949M"),
      ("7adca207cce144e398c1559d5e57fde4","2013SR133453","30200-0000","仟信德智能岗哨管理系统","","V1.0","厦门仟信德电子科技有限公司","350211200049114","91350213575026949M","福建","2013-11-27","2013-11-27","20171204","07tyc","X0100059_20171204_1204_天眼查_厦门仟信德电子科技有限公司","厦门仟信德电子科技有限公司","X0100059","","7adca207cce144e398c1559d5e57fde4","1C0G9801BNLL050C14AC00008A0FCB0E","91350213575026949M"),
      ("35ccefa2d0e271d7fbc91214b76f8acb","2015SR043586","30200-0000","时间都去哪了手机使用时长统计软件","时间都去哪了","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","2015-01-01","2015-03-11","20171024","05ccopyright","厦门手心文化传媒有限公司","厦门手心文化传媒有限公司","X0100061","","35ccefa2d0e271d7fbc91214b76f8acb","1BT609PI313Q980C14AC0000F268992B","913502030658875706"),
      ("d41d8cd98f00b204e9800998ecf8427e","2015SR043586","","时间都去哪了手机使用时长统计软件","时间都去哪了","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","","2015-03-11","20170323","03kaimaile","X0100047_20170323_0003_北京凯迈乐知识产权_软件著作权查询_厦门手心文化传媒有限公司","厦门手心文化传媒有限公司","X0100047","","d41d8cd98f00b204e9800998ecf8427e","1BBT24QHICGR9A0C14AC0000AD0BF82C","913502030658875706"),
      ("34f9f8a49c6ccb96fd1a53531a54f29d","2015SR043586","30200-0000","时间都去哪了手机使用时长统计软件","","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","2015-03-11","2015-03-11","20171213","07tyc","park_0099_厦门手心文化传媒有限公司","厦门手心文化传媒有限公司","X0100059","","34f9f8a49c6ccb96fd1a53531a54f29d","1C161CFLHORR030C14AC000098063FEA","913502030658875706"),
      ("","2015SR043586","30200-0000","时间都去哪了手机使用时长统计软件","时间都去哪了","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","2015-01-01","2015-03-11","20160310","01rjzzq","zhuzuoquan_20150219_956","厦门手心文化传媒有限公司","Z0100056","","","1ADEBK7854IO020C14AC00002FD21379","913502030658875706"),
      ("","2015SR043586","30200-0000","时间都去哪了手机使用时长统计软件","时间都去哪了","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","2015-03-11","2015-01-01","20161125","02qixinwang","org_qxw_rjzzq_20161122_5741","厦门手心文化传媒有限公司","X0100018","","","1B25I22UM8PO070C14AC000073F1E1B3","913502030658875706"),
      ("d41d8cd98f00b204e9800998ecf8427e","2015SR043586","30200-0000","时间都去哪了手机使用时长统计软件","时间都去哪了","V1.0","厦门手心文化传媒有限公司","350206200247648","913502030658875706","福建","2015-03-11","2015-01-01","20171218","02qixinwang","park_0099_厦门手心文化传媒有限公司","厦门手心文化传媒有限公司","X0100075","","d41d8cd98f00b204e9800998ecf8427e","1C1J6EPJNHLA0A0C14AC00000365313F","913502030658875706"))

    val dataFrame = seq.toDF("id","regno","classno","softname","softabbrename","verno","copyrightowner","reg_no","credit_no","province","publicationdate","recorddate","bizdate","data_source","loginid","user_id","retailerid","fkey","pkey","jobid","credit_reg")
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    // 将数据表数据映射成(key, columns(通过connectStr连接) + 时间字段索引 + 字段主键ID索引)
    val mappedRdd = dataFrame.rdd.map(item => {
      val createTimeIndex = item.fieldIndex("bizdate")
      val retaileridIndex = item.fieldIndex("retailerid")
      (item.getString(1) + item.getString(6), (item, createTimeIndex, retaileridIndex))
    })

    val rowRDDItems = mappedRdd.reduceByKey((item1, item2) => {

      val maxd = math.max(item1._1.size, item2._1.size)

      val bizdateIndex1 = item1._2
      val bizdateIndex2 = item2._2
      val retaileridIndex1 = item1._3
      val retaileridIndex2 = item2._3

      // 获取倒2个记录索引值
      val date1Str = item1._1.getString(bizdateIndex1)
      val date2Str = item2._1.getString(bizdateIndex2)
      val date1 = dateFormat.parse(date1Str)
      val date2 = dateFormat.parse(date2Str)
      val item1Retailerid = item1._1.getString(retaileridIndex1)
      val item2Retailerid = item2._1.getString(retaileridIndex2)

      println(policyCollect.mkString(","))
      println("item1Retailerid :" + item1Retailerid + "|    item2Retailerid:" + item2Retailerid + "| ")

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

      println("conditionStr1 :" + conditionStr1 + "|    conditionStr2:" + conditionStr2 + "| ")

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
        var itemValue1 = item1._1.getString(i)
        var itemValue2 = item2._1.getString(i)
        if (itemValue1 == null || itemValue2 == null) {
          if (itemValue1 == null) {
            if (itemValue2 == null) {
              itemValue2 = "NULL"
            }
            result += itemValue2 + connectStr
          } else {
            if (itemValue1 == null) {
              itemValue1 = "NULL"
            }
            result += itemValue1 + connectStr
          }
        } else if ("".equalsIgnoreCase(itemValue1.trim) || "".equalsIgnoreCase(itemValue2.trim) || "NULL".equalsIgnoreCase(itemValue1) || "NULL".equalsIgnoreCase(itemValue2)) {
          if ("NULL".equalsIgnoreCase(itemValue1) || "NULL".equalsIgnoreCase(itemValue2)) {
            if ("NULL".equalsIgnoreCase(itemValue1)) {
              if ("".equalsIgnoreCase(itemValue2.trim)) {
                itemValue2 = "NULL"
              }
              result += itemValue2 + connectStr
            } else {
              if ("".equalsIgnoreCase(itemValue1.trim)) {
                itemValue1 = "NULL"
              }
              result += itemValue1 + connectStr
            }
          } else {
            if ("".equalsIgnoreCase(itemValue1.trim) && "".equalsIgnoreCase(itemValue2.trim)) {
              result += "NULL" + connectStr
            } else {
              result += (itemValue1 + itemValue2) + connectStr
            }
          }
        } else {
          result = createResultContent(priority1, priority2, nowTime, item1ExpireTime, item2ExpireTime, result, itemValue1, itemValue2)
        }
      }
      val resultSplites = result.split(connectStr)
      val columnBean = createTableBean(resultSplites.length, resultSplites)
      (columnBean, item1._2, item1._3)
    })
    val rowRDD = rowRDDItems.map(_._2._1)
    sqlContext.createDataFrame(rowRDD, dataFrame.schema).show()

    sc.stop()

  }

  private def createResultContent(priority1: Int, priority2: Int, nowTime: Date, item1ExpireTime: Date, item2ExpireTime: Date, src: String, itemValue1: String, itemValue2: String) = {
    var result = src
    // priority1优先级高
    if (priority1 <= priority2) {
      if (priority1 == priority2) {
        if (item1ExpireTime.getTime < item2ExpireTime.getTime) {
          result += itemValue2 + connectStr
        } else {
          result += itemValue1 + connectStr
        }
      } else {
        // 记录1时间过期, 记录2时间未过期, 取记录2中的值
        if (item1ExpireTime.getTime < nowTime.getTime && item2ExpireTime.getTime >= nowTime.getTime) {
          result += itemValue2 + connectStr
        } else {
          result += itemValue1 + connectStr
        }
      }
    } else {
      if (item2ExpireTime.getTime < nowTime.getTime && item1ExpireTime.getTime >= nowTime.getTime) {
        result += itemValue1 + connectStr
      } else {
        result += itemValue2 + connectStr
      }
    }

    result
  }

  def createTableBean(columnLength: Int, splits: Array[String]): Row = {
    columnLength match {
      case 21 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14), splits(15), splits(16), splits(17)
          , splits(18), splits(19), splits(20))
        columnBean

      case 15 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14))
        columnBean
      case 8 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7))
        columnBean

      case 6 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4), splits(5))
        columnBean

      case 5 =>
        val columnBean = RowFactory.create(splits(0), splits(1), splits(2), splits(3), splits(4))
        columnBean

    }
  }

}
