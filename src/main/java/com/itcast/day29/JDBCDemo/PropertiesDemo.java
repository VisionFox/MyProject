package com.itcast.day29.JDBCDemo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //使用类加载器获取配置文件资源
        InputStream in= PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
        //System.out.println(in);
        Properties pro=new Properties();
        pro.load(in);
        //System.out.println(pro);
        String driverClass=pro.getProperty("driverClass");
        String url=pro.getProperty("url");
        String password=pro.getProperty("password");
        String username=pro.getProperty("username");

        Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println(con);

    }
}
