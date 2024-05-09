package com.mundo.etl.spark.postgres

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  测试向表中插入数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-07
  */
object InsertDataIntoTableSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("InsertDataIntoTableSuite").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    val df = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
        .load()

    import sqlContext.implicits._
    val seq = Seq(("商标", "101", "2001", "test", "test", "test"))
    val seqDf = sc.parallelize(seq).toDF("dimension", "primarykey", "sitename", "retailerid", "priority", "validity")
    seqDf.registerTempTable("site_priority_policy_tmp")
    seqDf.show()

    df.sqlContext.sql("insert into site_priority_policy select dimension,primarykey,sitename,retailerid,priority,validity " +
      " values('test', 'test', 'test', 'test', 'test', 'test')")
    seqDf.write.insertInto("site_priority_policy")

    sc.stop()
  }

}
