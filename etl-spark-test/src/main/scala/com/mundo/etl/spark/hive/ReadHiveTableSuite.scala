package com.mundo.etl.spark.hive

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  测试读取hive表数据，并写入另一张表
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-07
  */
object ReadHiveTableSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("ReadHiveTableSuite")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)

    val dataFrame = hiveContext.sql("select * from edw.site_priority_policy")
    hiveContext.sql("drop table if exists edw.site_priority_policy_tmp")
    dataFrame.write.mode(SaveMode.Append).saveAsTable("edw.site_priority_policy_tmp")

    sc.stop()
  }

}
