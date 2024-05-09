package com.mundo.etl.spark.utils

import org.apache.spark.sql.{Row, RowFactory}

/**
  * Description:  创建对应列的数据记录
  * Author: 赖传剑
  * Version: 1.0
  * Date: 2017-12-11
  */
object CreateRowUtil {

  def createRow(columnLength: Int, splits: Array[String]): Row = {
    columnLength match {

      case 15 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14))
        columnBean

      case 16 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15))
        columnBean

      case 17 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16))
        columnBean

      case 18 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17))
        columnBean

      case 19 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18))
        columnBean

      case 20 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19))
        columnBean

      case 21 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20))
        columnBean

      case 22 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21))
        columnBean

      case 23 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22))
        columnBean

      case 24 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23))
        columnBean

      case 25 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24))
        columnBean

      case 26 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25))
        columnBean

      case 27 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26))
        columnBean

      case 28 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27))
        columnBean

      case 29 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28))
        columnBean

      case 30 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29))
        columnBean

      case 31 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30))
        columnBean

      case 32 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31))
        columnBean

      case 33 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32))
        columnBean

      case 34 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33))
        columnBean

      case 35 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34))
        columnBean

      case 36 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35))
        columnBean

      case 37 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36))
        columnBean

      case 38 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37))
        columnBean

      case 39 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38))
        columnBean

      case 40 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39))
        columnBean

      case 41 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40))
        columnBean

      case 42 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41))
        columnBean

      case 43 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42))
        columnBean

      case 44 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43))
        columnBean

      case 45 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44))
        columnBean

      case 46 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45))
        columnBean


      case 47 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46))
        columnBean

      case 48 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47))
        columnBean

      case 49 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47), splits(48))
        columnBean


      case 50 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47), splits(48), splits(49))
        columnBean

      case 51 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47), splits(48), splits(49),
          splits(50))
        columnBean

      case 52 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47), splits(48), splits(49),
          splits(50), splits(51))
        columnBean

      case 53 =>
        val columnBean = RowFactory.create(
          splits(0), splits(1), splits(2), splits(3), splits(4), splits(5), splits(6), splits(7),
          splits(8), splits(9), splits(10), splits(11), splits(12), splits(13), splits(14),
          splits(15), splits(16), splits(17), splits(18), splits(19), splits(20), splits(21),
          splits(22), splits(23), splits(24), splits(25), splits(26), splits(27), splits(28),
          splits(29), splits(30), splits(31), splits(32), splits(33), splits(34), splits(35),
          splits(36), splits(37), splits(38), splits(39), splits(40), splits(41), splits(42),
          splits(43), splits(44), splits(45), splits(46), splits(47), splits(48), splits(49),
          splits(50), splits(51), splits(52))
        columnBean

    }

  }

}
