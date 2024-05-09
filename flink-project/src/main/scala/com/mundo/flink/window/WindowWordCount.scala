package com.mundo.flink.window

import java.util.Properties

import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.streaming.util.serialization.SimpleStringSchema

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-30
  */
object WindowWordCount {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val kafkaProps = new Properties()
    kafkaProps.setProperty("bootstrap.servers", "172.16.123.80:9092")
    kafkaProps.setProperty("group.id", "test-consumer-group")
    kafkaProps.setProperty("zookeeper.connect", "172.16.123.80:2181")
    kafkaProps.setProperty("topic", "test")
    val source = new FlinkKafkaConsumer[String]("test", new SimpleStringSchema, kafkaProps)

    val stream = env.addSource(source)

    val result = stream
      .flatMap(_.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .timeWindow(Time.seconds(5))
      .sum(1)
    result.print()
//    result.writeAsText("./test_result.txt")

    env.execute("read from kafka window operation")

  }

}
