package com.mundo.etl.spark.list

/**
  * Description:  
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object ListSuite {

  def main(args: Array[String]): Unit = {
    var x: List[String] = List()

    for (i <- 0 until 10) {
      x = i.toString +: x
    }
    println(x)
  }

}
