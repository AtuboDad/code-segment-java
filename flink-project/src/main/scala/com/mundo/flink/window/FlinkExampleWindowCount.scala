package com.mundo.flink.window

import com.mundo.flink.java.WordCountData
import org.apache.flink.api.scala._
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time

/**
  * Description:
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2018-01-30
  */
object FlinkExampleWindowCount {

  def main(args: Array[String]): Unit = {

    val params = ParameterTool.fromArgs(args)

    // set up the execution environment
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    // get input data
    val text =
      if (params.has("input")) {
        // read the text file from given input path
        env.readTextFile(params.get("input"))
      } else {
        println("Executing WindowWordCount example with default input data set.")
        println("Use --input to specify file input.")
        // get default test text data
        env.fromElements(WordCountData.WORDS: _*)
      }

    // make parameters available in the web interface
    env.getConfig.setGlobalJobParameters(params)

    val windowSize = params.getInt("window", 250)
    val slideSize = params.getInt("slide", 150)

    text
      // split up the lines in pairs (2-tuple) containing: (word,1)
      .flatMap(_.split("\\W+"))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .timeWindow(Time.seconds(10))
      // group by the tuple field "0" and sum up tuple field "1"
      .sum(1)

    // emit result
    //    if (params.has("output")) {
    //    counts.writeAsText("./test_result")
    //    } else {
    //      println("Printing result to stdout. Use --output to specify output path.")
    //      counts.print()
    //    }

    // execute program
    env.execute("WindowWordCount")

  }

}
