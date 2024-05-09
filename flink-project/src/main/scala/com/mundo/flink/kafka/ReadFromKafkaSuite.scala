package com.mundo.flink.kafka

import java.util.Properties

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

/**
  * Description:  从kafka源读取数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object ReadFromKafkaSuite {

  def main(args: Array[String]): Unit = {
    // parse input arguments
//    val parameterTool = ParameterTool.fromArgs(args)

//    if (parameterTool.getNumberOfParameters < 4) {
//      System.out.println("Missing parameters!\nUsage: Kafka --topic <topic> " + "--bootstrap.servers <kafka brokers> --zookeeper.connect <zk quorum> --group.id <some id>")
//      return
//    }

    val kafkaProps = new Properties()
    kafkaProps.setProperty("bootstrap.servers", "192.168.88.62:9092")
    kafkaProps.setProperty("group.id", "test-consumer-group")
    kafkaProps.setProperty("zookeeper.connect", "192.168.88.62:2181")
//    kafkaProps.setProperty("topic", "kafka_test")
    kafkaProps.setProperty("topic", "flume-data")

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.getConfig.setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000))
//    env.enableCheckpointing(5000) // create a checkpoint every 5 seconds

//    env.getConfig.setGlobalJobParameters(parameterTool) // make parameters available in the web interface

    val kafkaSource = new FlinkKafkaConsumer[String]("flume-data", new SimpleStringSchema, kafkaProps)
    val messageStream = env.addSource(kafkaSource)

    // write kafka stream to standard out.
    val value = messageStream.map(_.split("\\|")(0)).filter(_.nonEmpty).map(x => (x, 1L)).keyBy(_._1)
    val result = value.reduce((x1, x2) => (x1._1, x1._2 + x2._2))
    result.print()

    env.execute("Read from Kafka example")
  }

}
