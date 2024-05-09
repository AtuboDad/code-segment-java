package com.mundo.flink.datastream

import org.apache.flink.streaming.api.scala._

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object DataStreamApiSuite {

  def main(args: Array[String]): Unit = {
    // 创建Flink运行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val someDataStream: DataStream[Long] = env.generateSequence(0, 10)
    val mapStream = someDataStream.map((_, 1))

    mapStream.print()
    env.execute("DataStream API suite")

  }

}
