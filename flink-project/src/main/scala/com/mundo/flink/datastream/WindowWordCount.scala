package com.mundo.flink.datastream

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object WindowWordCount {

  def main(args: Array[String]): Unit = {
    // 创建Flink运行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    // 指定连接的主机、端口
    val text = env.socketTextStream("192.168.88.62", 9999)
    // 对输入数据进行单词切分、组合，并指定5秒的数据为一个窗口数据，最后统计
    val counts = text.flatMap(_.split(" ")).map((_, 1)).keyBy(0).timeWindow(Time.seconds(5)).sum(1)
    // 控制台输出结果
    counts.print()
    env.execute("Window Stream WordCount")
  }

}
