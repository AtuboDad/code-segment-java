package com.mundo.flink.table

import org.apache.flink.api.scala._
import org.apache.flink.table.api.DataTypes
import org.apache.flink.table.api.bridge.scala.BatchTableEnvironment
import org.apache.flink.table.api.internal.TableEnvironmentInternal
import org.apache.flink.table.sources.CsvTableSource

/**
 *
 * @author mundo
 */
object TableQuerySuite {

  def main(args: Array[String]): Unit = {
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
      //      .ignoreFirstLine()
      .commentPrefix("%")
      .build()

    tEnv.asInstanceOf[TableEnvironmentInternal].registerTableSourceInternal("hTable", source)
    val tableResult = tEnv.executeSql("select category,title,url from hTable")
    val its = tableResult.collect()
    while (its.hasNext) {
      val row = its.next()
      println(row)
    }

    //    val schema = new Schema()
    //      .field("category", DataTypes.STRING())
    //      .field("title", DataTypes.STRING())
    //      .field("url", DataTypes.STRING())
    //    val system = new FileSystem().path(tempFilePath)
    //    val deriveSchema = new Csv().fieldDelimiter('^').lineDelimiter("\n")
    //
    //    tEnv.connect(system)
    //      .withFormat(deriveSchema)
    //      .withSchema(schema)
    //      .createTemporaryTable("hTable");
    //
    //    val tableResult = tEnv.executeSql("select category,title,url from hTable")
    //    val it = tableResult.collect()
    //    if (it.hasNext) {
    //      val row = it.next()
    //      println(row)
}


}
