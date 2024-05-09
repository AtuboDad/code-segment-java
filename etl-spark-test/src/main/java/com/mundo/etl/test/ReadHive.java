package com.mundo.etl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadHive {

    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
        Connection connection = DriverManager.getConnection("jdbc:hive2://172.16.123.84:10000/edw", "", "");
        Statement stmt = connection.createStatement();
        String querySQL="select * from edw.f_sfpm_info";
        ResultSet resut = stmt.executeQuery(querySQL);
        while (resut.next()) {
            System.out.println(resut.getInt(1));
        }

    }

}
