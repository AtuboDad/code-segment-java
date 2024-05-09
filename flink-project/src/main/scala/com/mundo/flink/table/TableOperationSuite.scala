package com.mundo.flink.table

import java.util.Properties

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala.function.WindowFunction
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.table.api.bridge.scala.BatchTableEnvironment
import org.apache.flink.table.api.internal.TableEnvironmentInternal
import org.apache.flink.table.api.{DataTypes, _}
import org.apache.flink.table.sources.CsvTableSource
import org.apache.flink.util.Collector
import org.junit.Test

/**
 *
 * @author mundo
 */
class TableOperationSuite {

  @Test
  def testGroupBy(): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val tEnv = BatchTableEnvironment.create(env)
    val tempFilePath = "D:\\workspaces\\selfspaces\\work-apache-project\\data\\test.csv"

    val source = CsvTableSource.builder()
      .path(tempFilePath)
      .field("category", DataTypes.STRING)
      .field("title", DataTypes.STRING)
      .field("url", DataTypes.STRING)
      .fieldDelimiter("^")
      .lineDelimiter("\n")
      // .ignoreFirstLine()
      .commentPrefix("%")
      .build()

    tEnv.asInstanceOf[TableEnvironmentInternal].registerTableSourceInternal("csvTable", source)
    val table = tEnv.from("csvTable")
      .groupBy('title, 'category, 'url)
    val result = table
      .select('title, 'category, 'url)
      .execute()
    val its = result.collect()
    while (its.hasNext) {
      val row1 = its.next()
      println(row1)
    }
  }

  @Test
  def testEnvSource(): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val kafkaProps = new Properties()
    kafkaProps.setProperty("bootstrap.servers", "192.168.88.62:9092")
    kafkaProps.setProperty("group.id", "test-consumer-group")
    kafkaProps.setProperty("zookeeper.connect", "192.168.88.62:2181")
    kafkaProps.setProperty("topic", "kafka_test")
    env.getConfig.setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000))

    val simpleStringSchema = new SimpleStringSchema
    val kafkaSource = new FlinkKafkaConsumer[String]("kafka_test", simpleStringSchema, kafkaProps)

    val ds = env.addSource(kafkaSource)
    ds.map(_.split("^")).keyBy(0).timeWindow(Time.seconds(10))
    ds.print()

    env.execute("testEnvSource")
  }

}
