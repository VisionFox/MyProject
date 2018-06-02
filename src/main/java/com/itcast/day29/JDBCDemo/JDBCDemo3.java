package com.itcast.day29.JDBCDemo;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/study";
        String username="root";
        String password="zxc123";
        Connection con= DriverManager.getConnection(url,username,password);

        Scanner sc=new Scanner(System.in);
        String user=sc.nextLine();
        String pass=sc.nextLine();

        String sql="select * from user where uname=? and upass=?";

        PreparedStatement pst=con.prepareStatement(sql);
        pst.setObject(1,user);
        pst.setObject(2,pass);

        ResultSet rs=pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("uname")+"   "+rs.getString("upass"));
        }



    }
}
