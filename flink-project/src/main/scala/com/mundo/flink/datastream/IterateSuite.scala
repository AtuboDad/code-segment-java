package com.mundo.flink.datastream

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object IterateSuite {

  def main(args: Array[String]): Unit = {
    // 创建Flink运行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val someDataStream: DataStream[Long] = env.generateSequence(0, 10)

    val iteratedStream = someDataStream.iterate(
      iteration => {
        val minusOne = iteration.map(v => v - 1)
        val stillGreaterThanZero = minusOne.filter(_ > 0)
        val lessThanZero = minusOne.filter(_ <= 0)
        (stillGreaterThanZero, lessThanZero)
      }
    )

    iteratedStream.print()

    env.execute("Iterate Suite")

  }

}
