package com.javabigwork.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
    private static BasicDataSource dataSource=new BasicDataSource();

    static {
        dataSource.setDriverClassName(DBproperties.driverName);
        dataSource.setUrl(DBproperties.url);
        dataSource.setUsername(DBproperties.userName);
        dataSource.setPassword(DBproperties.password);
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
