package com.mundo.flink.utils

import java.text.SimpleDateFormat
import java.util.Date

/**
 *
 * @author mundo
 */
object DateUtil {

  def patten_y_M_d_H_m_s_S = "yyyy-MM-dd HH:mm:ss.SSS"
  def patten_y_M_d_H_m_s = "yyyy-MM-dd HH:mm:ss"
  def format = new SimpleDateFormat(patten_y_M_d_H_m_s_S)
  def format_y_M_d_H_m_s = new SimpleDateFormat(patten_y_M_d_H_m_s)

  def parseDate(date: String): Date = {
    format.parse(date)
  }

  def formatDate(date: Date): String = {
    format_y_M_d_H_m_s.format(date)
  }

}
