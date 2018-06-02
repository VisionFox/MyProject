package com.itcast.day29.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/study";
        String username="root";
        String password="zxc123";
        Connection con= DriverManager.getConnection(url,username,password);

        String sql="update sort set sname=?,sprice=? where sid=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setObject(1,"咸鱼");
        pst.setObject(2,99.9);
        pst.setObject(3,7);
        pst.executeUpdate();

        pst.close();
        con.close();
    }
}
