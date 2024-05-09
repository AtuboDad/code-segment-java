package com.mundo.flink.kafka

import java.util.Properties

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.util.serialization.SimpleStringSchema

/**
  * Description:  从kafka源读取数据，再写到kafka的另一个topic中
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-19
  */
object WriteToKafkaSuite {

  def main(args: Array[String]): Unit = {

    val kafkaProps = new Properties()
    kafkaProps.setProperty("bootstrap.servers", "172.16.123.80:9092")
    kafkaProps.setProperty("group.id", "test-consumer-group")
    kafkaProps.setProperty("zookeeper.connect", "172.16.123.80:2181")
    kafkaProps.setProperty("topic", "test")

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.getConfig.setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000))
    // create a checkpoint every 5 seconds
//    env.enableCheckpointing(5000)

    val kafkaSource = new FlinkKafkaConsumer[String]("test", new SimpleStringSchema, kafkaProps)

    val messageStream = env.addSource(kafkaSource)
    messageStream.flatMap(_.split(" ")).filter(_.nonEmpty)

    messageStream.print()

//    val kafkaProducer = new FlinkKafkaProducer010(
//      "test", // 这里要写到别的kafka topic
//      new SimpleStringSchema,
//      kafkaProps)
//    messageStream.addSink(kafkaProducer)

    env.execute("WriteToKafka")
  }

}
