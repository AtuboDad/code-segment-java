package com.mundo.etl.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description:  测试concat函数
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-05
  */
object ConcatSQLSuite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("BrandIndustryTest品牌行业").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlcontext = new SQLContext(sc)
    //对应的隐式转换，要有到Spark SQL下的一些函数
    import sqlcontext.implicits._
    val df = Seq((1, "101", "2001"), (1, "102", "2002"), (2, "202", "2003"), (2, "302", "2004")).toDF("id", "local", "num")
    df.show()

    df.registerTempTable("tmp_seq")

    sqlcontext.sql("select id,local,case when num<>'' then " +
      "concat(cast(cast(num as decimal(18,6))*1 as string),'人民币') end num_temp from tmp_seq ").show()

    sc.stop()

  }

}
