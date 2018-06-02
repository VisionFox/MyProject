package com.itcast.day30;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryRunnerDemo {
    private static Connection con=JDBCUtilsConfig.getConnection();

    public static void main(String[] args) throws SQLException {
        delete();
    }

    public static void delete() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="delete from sort where sid=?";
        qr.update(con,sql,9);
        DbUtils.closeQuietly(con);
    }

    public static void update() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="update sort set sname=?,sprice=?,sdesc=? where sid=?";
        Object[] params={"花卉",100.54,"卖花",4};
        int row=qr.update(con,sql,params);
        System.out.println(row);
        DbUtils.closeQuietly(con);
    }

    public static void insert() throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql="insert into sort(sname,sprice,sdesc) values(?,?,?)";
        Object[] params={"体育图片",289.03,"购买体育用品"};
        int row=qr.update(con,sql,params);
        System.out.println(row);
        DbUtils.close(con);
    }
}
