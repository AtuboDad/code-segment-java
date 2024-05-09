package com.mundo.flink.datastream

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object DataStreamPersonSuite {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    val flintstones = env.fromElements(new Person("李四", 35), new Person("李四", 35))

  }

  class Person() {
    var name: String = _
    var age: Integer = _

    def this(name: String, age: Integer) {
      this()
      this.name = name
      this.age = age
    }

    override def toString: String = this.name.toString + ": age " + this.age.toString
  }

}
