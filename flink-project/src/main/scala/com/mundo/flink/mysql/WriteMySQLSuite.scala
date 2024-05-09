package com.mundo.flink.mysql

import java.time.LocalDateTime

import org.apache.flink.api.common.typeinfo.BasicTypeInfo
import org.apache.flink.api.java.io.jdbc.{JDBCInputFormat, JDBCOutputFormat}
import org.apache.flink.api.java.typeutils.RowTypeInfo
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment, _}
import org.apache.flink.types.Row
import org.apache.log4j.Logger

object WriteMySQLSuite {

  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://192.168.88.91:3306/ezcun-dev?characterEncoding=UTF-8&autoReconnect=true&useUnicode=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true"
    val username = "gzy"
    val password = "gzy@5185188"
    val sql_write = "insert into attention_newdata(Hostname,ChannelNum,enabled,LastTime,CreateTime,ModifyTime) values(?,?,?,?,?,?) on duplicate key update ModifyTime=NOW()"
    val curTime = LocalDateTime.now().toString.replace("T", " ")
    val outputData = env.fromElements(("ttt", "0", "1", curTime, curTime, curTime))
      .map(x => {
        val row = new Row(6)
        row.setField(0, x._1)
        row.setField(1, x._2)
        row.setField(2, x._3)
        row.setField(3, x._4)
        row.setField(4, x._5)
        row.setField(5, x._6)
        row
      })
    writeMysql(env, outputData, url, driver, username, password, sql_write)
  }

  // 写mysql
  def writeMysql(env: ExecutionEnvironment, outputData: DataSet[Row], url: String, driver: String, user: String, pwd: String, sql: String) = {
    outputData.output(JDBCOutputFormat.buildJDBCOutputFormat()
      .setDrivername(driver)
      .setDBUrl(url)
      .setUsername(user)
      .setPassword(pwd)
      .setQuery(sql)
      .finish())
    env.execute("insert data to mysql")
    print("data write successfully")
  }

}
