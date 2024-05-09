package com.mundo.flink.kafka

import java.util.Properties

import com.mundo.flink.utils.DateUtil
import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer, KafkaTableSource}
import org.apache.flink.api.scala._
import org.apache.flink.table.api.{DataTypes, EnvironmentSettings, TableEnvironment, TableSchema}
import org.apache.flink.table.api.bridge.scala.{BatchTableEnvironment, StreamTableEnvironment}
import org.apache.flink.table.api.internal.TableEnvironmentInternal
import org.apache.flink.table.descriptors.Schema
import org.apache.flink.table.sources.CsvTableSource


/**
  * Description:  从kafka源读取数据
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-18
  */
object ReadFromKafkaSuiteV2 {

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
//    val tEnv = StreamTableEnvironment.create(env)
    env.getConfig.setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000))
//    env.enableCheckpointing(5000) // create a checkpoint every 5 seconds

//    env.getConfig.setGlobalJobParameters(parameterTool) // make parameters available in the web interface

    val kafkaSource = new FlinkKafkaConsumer[String]("flume-data", new SimpleStringSchema, kafkaProps)
    val messageStream = env.addSource(kafkaSource)
    val accessLogs = messageStream.map(line => {
      val lineItems = line.split("\\|")
      if (lineItems.length == 6) {
        val accessLogRecord = new AccessLogRecord()
        try {
          val timeStr = lineItems(0)
          val date = DateUtil.parseDate(timeStr)
          accessLogRecord.setTimeStr(DateUtil.formatDate(date))
          accessLogRecord.setThreadName(lineItems(1))
          accessLogRecord.setLogLevel(lineItems(2))
          accessLogRecord.setLoaderName(lineItems(3))
          accessLogRecord.setContent(lineItems(4))
          accessLogRecord
        } catch {
          case ex: Exception => accessLogRecord
        }
      }
    }).filter(_.isInstanceOf[AccessLogRecord]).map(item => {
      val accessLogRecord = item.asInstanceOf[AccessLogRecord]
      (accessLogRecord.getTimeStr().concat("-->").concat(accessLogRecord.getThreadName()), 1)
    }).keyBy(_._1).sum(1)

    accessLogs.print()

    env.execute("Read from Kafka example")
  }

}
