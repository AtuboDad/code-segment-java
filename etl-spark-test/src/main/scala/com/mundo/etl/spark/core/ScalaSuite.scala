package com.mundo.etl.spark.core

object ScalaSuite {

  def main(args: Array[String]): Unit = {

    val arr1 = Array("message 1")

    val strings = arr1.map(x => x.split(" ")(0))

    strings.foreach(println)

  }
}
