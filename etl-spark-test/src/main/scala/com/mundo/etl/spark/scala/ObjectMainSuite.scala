package com.mundo.etl.spark.scala

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-14
  */
object ObjectMainSuite {

  private var master: String = _

  def main(args: Array[String]): Unit = {
    master = "test"
  }

  private[etl] def testMethod(): Unit = {
    println(master)
  }

}
