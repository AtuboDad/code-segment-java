package com.mundo.flink.mysql

import java.time.LocalDateTime

import org.apache.flink.api.common.typeinfo.BasicTypeInfo
import org.apache.flink.api.java.io.jdbc.{JDBCInputFormat, JDBCOutputFormat}
import org.apache.flink.api.java.typeutils.RowTypeInfo
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment, _}
import org.apache.flink.types.Row
import org.apache.log4j.Logger

object ReadMySQLSuite {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://192.168.88.91:3306/ezcun-dev?characterEncoding=UTF-8&autoReconnect=true&useUnicode=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true"
    val username = "gzy"
    val password = "gzy@5185188"
    val sql_read = "select evid_id,user_id,evid_name from tb_evid limit 10"
    readMysql(env, url, driver, username, password, sql_read)
  }

  /**
   * 读mysql
   *
   * @param env
   * @param url
   * @param user
   * @param pwd
   * @param sql
   */
  def readMysql(env: ExecutionEnvironment, url: String, driver: String, user: String, pwd: String, sql: String) = {
    val dataResult: DataSet[Row] = env.createInput(JDBCInputFormat.buildJDBCInputFormat()
      .setDrivername(driver)
      .setDBUrl(url)
      .setUsername(user)
      .setPassword(pwd)
      .setQuery(sql)
      .setRowTypeInfo(new RowTypeInfo(
        BasicTypeInfo.STRING_TYPE_INFO,
        BasicTypeInfo.STRING_TYPE_INFO,
        BasicTypeInfo.STRING_TYPE_INFO))
      .finish())
    dataResult.map(x => {
      val relationid = x.getField(0)
      val year = x.getField(1)
      val month = x.getField(2)
      (relationid, year, month)
    }).print()
  }
}
