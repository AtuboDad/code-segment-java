package com.mundo.etl.spark.hive

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  合并hive表中数据，测试表：site_priority_policy_data
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-08
  */
object MergerHiveDataSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerHiveDataSuite")
    val sc = new SparkContext(conf)
    val sql = new HiveContext(sc)

    import sql.implicits._

    val edwSiteDf = sql.sql("FROM edw.site_priority_policy SELECT *")
    edwSiteDf.show()
    val retaileridInfoRdd = edwSiteDf.map(item => { (item.getString(3), item.getString(4), item.getString(5))})

    val edwTestDataDf = sql.sql("SELECT t1* FROM edw_test.site_priority_policy_data t1 LEFT JOIN edw_test.site_priority_policy_data t2 on " +
      "t1.name=t2.name AND t1.retailerid=t2.retailerid")
    edwTestDataDf.show()

    sc.stop()

  }

}
