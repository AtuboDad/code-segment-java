package com.mundo.flink.kafka

/**
 *
 * @author mundo
 */
class AccessLogRecord() {
  var timeStr: String = _
  var threadName: String = _
  var logLevel: String = _
  var loaderName: String = _
  var content: String = _

  def setTimeStr(timeStr: String): Unit = {
    this.timeStr = timeStr
  }
  def getTimeStr(): String = {
    this.timeStr
  }
  def setThreadName(threadName: String): Unit = {
    this.threadName = threadName
  }
  def getThreadName(): String = {
    this.threadName
  }
  def setLogLevel(logLevel: String): Unit = {
    this.logLevel = logLevel
  }
  def setLoaderName(loaderName: String): Unit = {
    this.loaderName = loaderName
  }
  def setContent(content: String): Unit = {
    this.content = content
  }

  def nonEmpty(): Boolean = {
    null == this
  }

  override def toString: String = timeStr + "|" + threadName + "|" + logLevel + "|" + loaderName + "|" + content
}
