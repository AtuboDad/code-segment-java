package com.mundo.etl.spark.utils

import org.apache.spark.sql.{Row, RowFactory}

/**
  * Description:  创建对应列的数据记录
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object CreateRowUtilV3 {

  def createRow(columnLength: Int, splits: Array[String]): Row = {
    columnLength match {

      case 15 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14
        )
        columnBean
      case 16 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15
        )
        columnBean
      case 17 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16
        )
        columnBean
      case 18 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17
        )
        columnBean
      case 19 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18
        )
        columnBean
      case 20 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19
        )
        columnBean
      case 21 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20
        )
        columnBean
      case 22 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }

        var item21 = ""
        try {
          item21 = splits(21)
          if ("NULL".equalsIgnoreCase(item21)) {
            item21 = ""
          }
        } catch {
          case e: Exception =>
            item21 = "There is a error here"
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21
        )
        columnBean
      case 23 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22
        )
        columnBean
      case 24 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23
        )
        columnBean
      case 25 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24
        )
        columnBean
      case 26 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25
        )
        columnBean
      case 27 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26
        )
        columnBean
      case 28 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27
        )
        columnBean
      case 29 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28
        )
        columnBean
      case 30 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29
        )
        columnBean
      case 31 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30
        )
        columnBean
      case 32 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31
        )
        columnBean
      case 33 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        var item32 = splits(32)
        if ("NULL".equalsIgnoreCase(item32)) {
          item32 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32
        )
        columnBean
      case 34 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        var item32 = splits(32)
        if ("NULL".equalsIgnoreCase(item32)) {
          item32 = ""
        }
        var item33 = splits(33)
        if ("NULL".equalsIgnoreCase(item33)) {
          item33 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33
        )
        columnBean
      case 35 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        var item32 = splits(32)
        if ("NULL".equalsIgnoreCase(item32)) {
          item32 = ""
        }
        var item33 = splits(33)
        if ("NULL".equalsIgnoreCase(item33)) {
          item33 = ""
        }
        var item34 = splits(34)
        if ("NULL".equalsIgnoreCase(item34)) {
          item34 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34
        )
        columnBean
      case 36 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        var item32 = splits(32)
        if ("NULL".equalsIgnoreCase(item32)) {
          item32 = ""
        }
        var item33 = splits(33)
        if ("NULL".equalsIgnoreCase(item33)) {
          item33 = ""
        }
        var item34 = splits(34)
        if ("NULL".equalsIgnoreCase(item34)) {
          item34 = ""
        }
        var item35 = splits(35)
        if ("NULL".equalsIgnoreCase(item35)) {
          item35 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35
        )
        columnBean
      case 37 =>
        var item0 = splits(0)
        if ("NULL".equalsIgnoreCase(item0)) {
          item0 = ""
        }
        var item1 = splits(1)
        if ("NULL".equalsIgnoreCase(item1)) {
          item1 = ""
        }
        var item2 = splits(2)
        if ("NULL".equalsIgnoreCase(item2)) {
          item2 = ""
        }
        var item3 = splits(3)
        if ("NULL".equalsIgnoreCase(item3)) {
          item3 = ""
        }
        var item4 = splits(4)
        if ("NULL".equalsIgnoreCase(item4)) {
          item4 = ""
        }
        var item5 = splits(5)
        if ("NULL".equalsIgnoreCase(item5)) {
          item5 = ""
        }
        var item6 = splits(6)
        if ("NULL".equalsIgnoreCase(item6)) {
          item6 = ""
        }
        var item7 = splits(7)
        if ("NULL".equalsIgnoreCase(item7)) {
          item7 = ""
        }
        var item8 = splits(8)
        if ("NULL".equalsIgnoreCase(item8)) {
          item8 = ""
        }
        var item9 = splits(9)
        if ("NULL".equalsIgnoreCase(item9)) {
          item9 = ""
        }
        var item10 = splits(10)
        if ("NULL".equalsIgnoreCase(item10)) {
          item10 = ""
        }
        var item11 = splits(11)
        if ("NULL".equalsIgnoreCase(item11)) {
          item11 = ""
        }
        var item12 = splits(12)
        if ("NULL".equalsIgnoreCase(item12)) {
          item12 = ""
        }
        var item13 = splits(13)
        if ("NULL".equalsIgnoreCase(item13)) {
          item13 = ""
        }
        var item14 = splits(14)
        if ("NULL".equalsIgnoreCase(item14)) {
          item14 = ""
        }
        var item15 = splits(15)
        if ("NULL".equalsIgnoreCase(item15)) {
          item15 = ""
        }
        var item16 = splits(16)
        if ("NULL".equalsIgnoreCase(item16)) {
          item16 = ""
        }
        var item17 = splits(17)
        if ("NULL".equalsIgnoreCase(item17)) {
          item17 = ""
        }
        var item18 = splits(18)
        if ("NULL".equalsIgnoreCase(item18)) {
          item18 = ""
        }
        var item19 = splits(19)
        if ("NULL".equalsIgnoreCase(item19)) {
          item19 = ""
        }
        var item20 = splits(20)
        if ("NULL".equalsIgnoreCase(item20)) {
          item20 = ""
        }
        var item21 = splits(21)
        if ("NULL".equalsIgnoreCase(item21)) {
          item21 = ""
        }
        var item22 = splits(22)
        if ("NULL".equalsIgnoreCase(item22)) {
          item22 = ""
        }
        var item23 = splits(23)
        if ("NULL".equalsIgnoreCase(item23)) {
          item23 = ""
        }
        var item24 = splits(24)
        if ("NULL".equalsIgnoreCase(item24)) {
          item24 = ""
        }
        var item25 = splits(25)
        if ("NULL".equalsIgnoreCase(item25)) {
          item25 = ""
        }
        var item26 = splits(26)
        if ("NULL".equalsIgnoreCase(item26)) {
          item26 = ""
        }
        var item27 = splits(27)
        if ("NULL".equalsIgnoreCase(item27)) {
          item27 = ""
        }
        var item28 = splits(28)
        if ("NULL".equalsIgnoreCase(item28)) {
          item28 = ""
        }
        var item29 = splits(29)
        if ("NULL".equalsIgnoreCase(item29)) {
          item29 = ""
        }
        var item30 = splits(30)
        if ("NULL".equalsIgnoreCase(item30)) {
          item30 = ""
        }
        var item31 = splits(31)
        if ("NULL".equalsIgnoreCase(item31)) {
          item31 = ""
        }
        var item32 = splits(32)
        if ("NULL".equalsIgnoreCase(item32)) {
          item32 = ""
        }
        var item33 = splits(33)
        if ("NULL".equalsIgnoreCase(item33)) {
          item33 = ""
        }
        var item34 = splits(34)
        if ("NULL".equalsIgnoreCase(item34)) {
          item34 = ""
        }
        var item35 = splits(35)
        if ("NULL".equalsIgnoreCase(item35)) {
          item35 = ""
        }
        var item36 = splits(36)
        if ("NULL".equalsIgnoreCase(item36)) {
          item36 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36
        )
        columnBean

    }

  }

}
