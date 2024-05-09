package com.mundo.flink.datastream

import java.util.concurrent.TimeUnit

import org.apache.flink.api.common.serialization.SimpleStringEncoder
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy
import org.apache.flink.streaming.api.scala._

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object ReadFileWordCount {

  def main(args: Array[String]): Unit = {
    // 创建Flink运行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    // 指定连接的主机、端口
    val text = env.readTextFile("file:///usr/local/flink-1.11.2/README.txt");
    // 对输入数据进行单词切分、组合，并指定5秒的数据为一个窗口数据，最后统计
    val counts = text.flatMap(_.split(" ")).filter(item => !item.trim().equalsIgnoreCase("")).map((_, 1)).keyBy(0).sum(1)
    // 控制台输出结果
//    counts.print()

    val sink: StreamingFileSink[String] = StreamingFileSink
      .forRowFormat(new Path("hdfs://localhost:8020/flink/dirs"), new SimpleStringEncoder[String]("UTF-8"))
      .withRollingPolicy(
        DefaultRollingPolicy.builder()
          .withRolloverInterval(TimeUnit.MINUTES.toMillis(15))
          .withInactivityInterval(TimeUnit.MINUTES.toMillis(5))
          .withMaxPartSize(1024 * 1024 * 1024)
          .build())
      .build()

    text.addSink(sink)
//    counts.writeAsText("hdfs://192.168.88.61:9000/flink/textResult")

    env.execute("Read File WordCount")
  }

}
