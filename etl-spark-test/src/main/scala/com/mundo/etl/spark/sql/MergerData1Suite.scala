package com.mundo.etl.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Description: 分组求topN
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-06
  */
object MergerData1Suite {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("MergerData1Suite").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlcontext = new SQLContext(sc)
    // 对应的隐式转换，要有到Spark SQL下的一些函数
    import sqlcontext.implicits._
    val df = Seq((1, "101", "", 3), (1, "", "2002", 4), (2, "202", "2003", 3), (2, "302", "", 4)).toDF("id", "local", "num", "date")

    df.registerTempTable("tmp_test_table")
    sqlcontext.sql("select t1.id, t1.local, t2.num, t1.date from tmp_test_table t1 " +
      "left join tmp_test_table t2 on t1.id=t2.id " +
      "where t1.local<>'' and t2.num<>''").registerTempTable("tmp_test_table1")

    val dataFrame = sqlcontext.sql("select * from tmp_test_table1")
    val pairs = dataFrame.rdd.map(x => {
      val splited = x.mkString(",").split(",")
      (splited(0), (splited(1), splited(2), splited(3).toInt))
    })

    pairs.groupByKey().map(classScores => {
      val className = classScores._1
      val scores = classScores._2

      val value = scores.maxBy(_._3)

      (className, value._1, value._2, value._3)
    }).foreach(item => {
      println(item)
    })

    sc.stop()

  }

}
