package com.itcast.day30;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceDemo {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/study");
        dataSource.setUsername("root");
        dataSource.setPassword("zxc123");

        try {
            Connection con=dataSource.getConnection();
            System.out.println(con);
        }catch (SQLException e){
            System.out.println(e);
            throw new RuntimeException("数据库连接失败");
        }
    }
}
