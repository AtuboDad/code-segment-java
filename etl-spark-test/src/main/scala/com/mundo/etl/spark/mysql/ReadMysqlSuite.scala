package com.mundo.etl.spark.mysql

import org.apache.spark.sql.{DataFrame, SparkSession}

object ReadMysqlSuite {

  def main(args: Array[String]): Unit = {
    val session = SparkSession.builder().master("local[2]").appName("ReadMysqlSuite").getOrCreate()
    val dim_sys_city_dict: DataFrame = readMysqlTable(session, "tb_web_forensics_server")
    dim_sys_city_dict.show()
  }

  /**
   * 获取 Mysql 表的数据
   *
   * @param session
   * @param tableName 读取Mysql表的名字
   * @return 返回 Mysql 表的 DataFrame
   */
  def readMysqlTable(session: SparkSession, tableName: String) = {
    session
      .read
      .format("jdbc")
      .option("url", "jdbc:mysql://192.168.88.91:3306/ezcun-dev?characterEncoding=UTF-8&autoReconnect=true&useUnicode=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "gzy")
      .option("password", "gzy@5185188")
      //        .option("dbtable", tableName.toUpperCase)
      .option("dbtable", tableName)
      .load()

  }

}
