package com.mundo.etl.spark.scala

/**
  * Description:  测试mkString
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object StringTest {

  val connectStr = "MM&"

  def main(args: Array[String]): Unit = {
    val seq = Seq("dfb2e9731a0098afaade3367d72f0a44","http://img.shangdun.org/Img.asp?R=14750712&T=7","宇杰","14750712","商标注册申请等待驳回复审","-","7","2014-05-23","漳州市宇杰包装机械有限公司","","","","","","","0708 0721 0728 0734 0753","压茶砖机；揉捻机（制茶工业用）；烘干机（制茶工业用）；包装机（打包机）；捆扎机；打包机；包装机；化肥制造设备；装卸设备；滤筛机；","","","-","-","- - -","-","-","-","","否","","否","商标注册申请等待驳回复审"," ① 2014-05-23 商标注册申请中 ② 2014-09-28 商标注册申请受理通知书发文 ③ 2015-04-25 商标注册申请等待驳回通知发文 ④ 2015-06-20商标注册申请等待驳回复审","","","","20170404","01sdw","X0100013_20170328_0001_商盾网_企业名称_商标查询_漳州市宇杰包装机械有限公司","漳州市宇杰包装机械有限公司","X0100013","","dfb2e9731a0098afaade3367d72f0a44","1BCQA02Q3U6B9A0C14AC0000DD9FDFBE","")
    println(seq.length)
  }

}
