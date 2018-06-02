package com.javabigwork.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBproperties {
    public static String driverName;
    public static String url;
    public static String userName;
    public static String password;

    static {
        InputStream in = null;
        Properties pro = new Properties();

        try {
            in = DBproperties.class.getClassLoader().getResourceAsStream("javaWorkDB.properties");
            pro.load(in);
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("配置文件加载失败");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e);
                    throw new RuntimeException("配置文件流关闭失败");
                }
            }
        }

        DBproperties.driverName=pro.getProperty("driverClass");
        DBproperties.url=pro.getProperty("url");
        DBproperties.userName=pro.getProperty("username");
        DBproperties.password=pro.getProperty("password");
    }
}
