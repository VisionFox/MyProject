package com.itcast.day29.JDBCDemo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //用反射技术 将驱动类加载到内存
       // DriverManager.registerDriver(new Driver());这个会注册两次浪费 因为Driver类里已经静态注册过了
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接
        String url="jdbc:mysql://localhost:3306/study";
        String username="root";
        String password="zxc123";
        Connection con= DriverManager.getConnection(url,username,password);
        //返回的是connection接口的实现类，上面全是java。sql包里的东西
        System.out.println(con);
        //3.获得语句执行平台
        Statement stat= con.createStatement();//获得也是接口的实现类,全是java.sql包里的
        //4执行sql语句
        //int executeUpdate()这个只允许执行delect update insert并且返回操作成功的行数
        int rows= stat.executeUpdate("INSERT INTO sort(sname,sprice,sdesc) VALUES ('汽车用品',5000,'疯狂涨价')");
        System.out.println(rows);

        //6.释放资源
        stat.close();
        con.close();
    }
}
