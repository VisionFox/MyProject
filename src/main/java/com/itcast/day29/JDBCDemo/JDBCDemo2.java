package com.itcast.day29.JDBCDemo;

import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        String url="jdbc:mysql://localhost:3306/study";
        String username="root";
        String password="zxc123";
        Connection con= DriverManager.getConnection(url,username,password);
        //3.获取执行平台
        Statement stat=con.createStatement();

        String sql="select * from sort";
        //4.执行语句，获取结果集
        ResultSet rs=stat.executeQuery(sql);
        //5.处理结果集
        while (rs.next()){
            System.out.println(rs.getInt("sid")+"  "+rs.getString("sname")+
            "  "+ rs.getDouble("sprice")+"  "+rs.getString("sdesc"));
        }
        rs.close();
        stat.close();
        con.close();
    }
}
