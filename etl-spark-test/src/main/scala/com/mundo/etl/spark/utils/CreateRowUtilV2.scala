package com.mundo.etl.spark.utils

import org.apache.spark.sql.{Row, RowFactory}

/**
  * Description:  创建对应列的数据记录
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object CreateRowUtilV2 {

  def createRow(columnLength: Int, splits: Array[String]): Row = {
    columnLength match {
      case 38 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37
        )
        columnBean
      case 39 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38
        )
        columnBean
      case 40 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39
        )
        columnBean
      case 41 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40
        )
        columnBean
      case 42 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41
        )
        columnBean
      case 43 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42
        )
        columnBean
      case 44 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43
        )
        columnBean
      case 45 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44
        )
        columnBean
      case 46 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45
        )
        columnBean
      case 47 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46
        )
        columnBean
      case 48 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47
        )
        columnBean
      case 49 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        var item48 = splits(48)
        if ("NULL".equalsIgnoreCase(item48)) {
          item48 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48
        )
        columnBean
      case 50 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        var item48 = splits(48)
        if ("NULL".equalsIgnoreCase(item48)) {
          item48 = ""
        }
        var item49 = splits(49)
        if ("NULL".equalsIgnoreCase(item49)) {
          item49 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48,item49
        )
        columnBean
      case 51 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        var item48 = splits(48)
        if ("NULL".equalsIgnoreCase(item48)) {
          item48 = ""
        }
        var item49 = splits(49)
        if ("NULL".equalsIgnoreCase(item49)) {
          item49 = ""
        }
        var item50 = splits(50)
        if ("NULL".equalsIgnoreCase(item50)) {
          item50 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48,item49,item50
        )
        columnBean
      case 52 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        var item48 = splits(48)
        if ("NULL".equalsIgnoreCase(item48)) {
          item48 = ""
        }
        var item49 = splits(49)
        if ("NULL".equalsIgnoreCase(item49)) {
          item49 = ""
        }
        var item50 = splits(50)
        if ("NULL".equalsIgnoreCase(item50)) {
          item50 = ""
        }
        var item51 = splits(51)
        if ("NULL".equalsIgnoreCase(item51)) {
          item51 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48,item49,item50,item51
        )
        columnBean
      case 53 =>
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
        var item37 = splits(37)
        if ("NULL".equalsIgnoreCase(item37)) {
          item37 = ""
        }
        var item38 = splits(38)
        if ("NULL".equalsIgnoreCase(item38)) {
          item38 = ""
        }
        var item39 = splits(39)
        if ("NULL".equalsIgnoreCase(item39)) {
          item39 = ""
        }
        var item40 = splits(40)
        if ("NULL".equalsIgnoreCase(item40)) {
          item40 = ""
        }
        var item41 = splits(41)
        if ("NULL".equalsIgnoreCase(item41)) {
          item41 = ""
        }
        var item42 = splits(42)
        if ("NULL".equalsIgnoreCase(item42)) {
          item42 = ""
        }
        var item43 = splits(43)
        if ("NULL".equalsIgnoreCase(item43)) {
          item43 = ""
        }
        var item44 = splits(44)
        if ("NULL".equalsIgnoreCase(item44)) {
          item44 = ""
        }
        var item45 = splits(45)
        if ("NULL".equalsIgnoreCase(item45)) {
          item45 = ""
        }
        var item46 = splits(46)
        if ("NULL".equalsIgnoreCase(item46)) {
          item46 = ""
        }
        var item47 = splits(47)
        if ("NULL".equalsIgnoreCase(item47)) {
          item47 = ""
        }
        var item48 = splits(48)
        if ("NULL".equalsIgnoreCase(item48)) {
          item48 = ""
        }
        var item49 = splits(49)
        if ("NULL".equalsIgnoreCase(item49)) {
          item49 = ""
        }
        var item50 = splits(50)
        if ("NULL".equalsIgnoreCase(item50)) {
          item50 = ""
        }
        var item51 = splits(51)
        if ("NULL".equalsIgnoreCase(item51)) {
          item51 = ""
        }
        var item52 = splits(52)
        if ("NULL".equalsIgnoreCase(item52)) {
          item52 = ""
        }
        val columnBean = RowFactory.create(
          item0,item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48,item49,item50,item51,item52
        )
        columnBean

    }

  }

}
