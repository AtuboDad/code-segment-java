package com.mundo.etl.spark.postgres

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  从postgres中读取数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-07
  */
object PropFromPostgresSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("PropFromPostgresSuite").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val dbDF = sqlContext.read.format("jdbc")
      .option("url", "jdbc:postgresql://172.16.123.80:5432/spider2.1")
      .option("dbtable", "site_priority_policy")
      .option("user", "spider")
      .option("password", "spider")
      .load()

    dbDF.registerTempTable("site_priority_policy")
    val df = sqlContext.sql("select * from site_priority_policy order by priority")
    df.show()

//    df.map(item => {
//      val retailerid = item.getString(3)
//      val priority = item.getInt(4)
//      val validity = item.getInt(5)
//      (retailerid, priority, validity)
//    }).foreach(println)

    import sqlContext.implicits._

//    val columns = df.columns
//    for (column <- columns) {
//      println(column)
//    }

//    println(df.schema)

    sc.stop()

  }

}
