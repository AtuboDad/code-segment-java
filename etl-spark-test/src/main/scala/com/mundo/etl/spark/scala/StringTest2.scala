package com.mundo.etl.spark.scala

import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Description:  测试mkString
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object StringTest2 {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {
    val str = "X0100018MM&2MM&60MM&"
    val strings = str.split(connectStr)
    println(strings.length)
  }

}
