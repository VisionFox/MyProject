package com.itcast.day29.JDBCDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtilsConfig {
    public static void main(String[] args) throws SQLException {
        Connection con=JDBCUtilsConfig.getConnection();
        System.out.println(con);
        Statement stat= con.createStatement();
        ResultSet rs= stat.executeQuery("SELECT * FROM sort");
        while (rs.next()){
            System.out.println(rs.getObject("sname"));
        }
    }
}
