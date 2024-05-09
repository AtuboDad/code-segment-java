package com.mundo.flink.table.planner

import org.apache.flink.api.common.typeinfo.Types.STRING
import org.apache.flink.api.scala._
import org.apache.flink.table.api._
import org.apache.flink.table.functions._
import org.apache.flink.table.sinks._
import org.apache.flink.table.planner._
import org.apache.flink.streaming.api.environment.LocalStreamEnvironment
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.bridge.scala.{StreamTableEnvironment, _}
import org.apache.flink.table.catalog.{GenericInMemoryCatalog, ObjectPath}
import org.apache.flink.types.Row
import org.apache.calcite.plan.RelOptUtil
import org.apache.calcite.sql.SqlExplainLevel
import org.junit.Assert.{assertEquals, assertFalse, assertTrue, fail}
import org.junit.rules.ExpectedException
import org.junit.{Rule, Test}
import _root_.java.util

import org.apache.flink.table.api.internal.{TableEnvironmentImpl, TableImpl}
import org.apache.flink.table.api.{EnvironmentSettings, ValidationException}
import org.apache.flink.table.planner.delegation.PlannerBase

import _root_.scala.collection.JavaConverters._

class TableEnvironmentTest {

  // used for accurate exception information checking.
  val expectedException: ExpectedException = ExpectedException.none()
  val STREAM_SETTING: EnvironmentSettings =
    EnvironmentSettings.newInstance().inStreamingMode().build()

  @Rule
  def thrown: ExpectedException = expectedException

  val env = new StreamExecutionEnvironment(new LocalStreamEnvironment())
  val tableEnv = StreamTableEnvironment.create(env, STREAM_SETTING)

  @Test
  def testScanNonExistTable(): Unit = {
    thrown.expect(classOf[ValidationException])
    thrown.expectMessage("Table `MyTable` was not found")
    tableEnv.from("MyTable")
  }

  @Test
  def testRegisterDataStream(): Unit = {
    val table = env.fromElements[(Int, Long, String, Boolean)]().toTable(tableEnv, 'a, 'b, 'c, 'd)
    tableEnv.createTemporaryView("MyTable", table)
    val scanTable = tableEnv.from("MyTable")
    val aField = scanTable.select('a)
    print(aField)
  }

}