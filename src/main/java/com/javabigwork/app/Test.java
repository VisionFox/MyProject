package com.javabigwork.app;

import com.javabigwork.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    private static int id = 0;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println("请输入盘符（只输入c、d、e、f...就行,大小写均可）：");
        Scanner sc = new Scanner(System.in);
        String root = sc.nextLine();
        File file = new File(root + ":\\");


        init();
        long start = System.currentTimeMillis();
        searchFile(file);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "毫秒");
        function_1();
        function_2();
    }

    public static void init() {
        String sql = "truncate table fileinfo";
        try {
            qr.update(sql);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void searchFile(File file) throws IOException, NoSuchAlgorithmException {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() && files[i].length() != 0) {
                searchFile(files[i]);
            } else if (files[i].isFile()) {
                if (files[i].getAbsolutePath().toUpperCase().endsWith(".EXE") || files[i].getAbsolutePath().toUpperCase().endsWith(".DLL") ||
                        files[i].getAbsolutePath().toUpperCase().endsWith(".SCR") || files[i].getAbsolutePath().toUpperCase().endsWith(".OCX")
                        || files[i].getAbsolutePath().toUpperCase().endsWith(".CPL") || files[i].getAbsolutePath().toUpperCase().endsWith(".DRV")
                        || files[i].getAbsolutePath().toUpperCase().endsWith(".SYS") || files[i].getAbsolutePath().toUpperCase().endsWith(".VXD")
                        || files[i].getAbsolutePath().toUpperCase().endsWith(".OBJ")) {

                    writeToDB(files[i].getAbsolutePath(), getMD5(files[i]));
                }
            }
        }
    }

    public static String getMD5(File file) throws IOException, NoSuchAlgorithmException {
        byte[] bytes = creatCheckSum(file);
        String result = "";

        for (int i = 0; i < bytes.length; i++) {
            result += Integer.toString((bytes[i] & 0xff) + 0x100, 16);
        }
        return result;
    }

    public static byte[] creatCheckSum(File file) throws IOException, NoSuchAlgorithmException {
        InputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");

        int len;

        while ((len = fis.read(buffer)) != -1) {
            complete.update(buffer, 0, len);
        }
        fis.close();
        return complete.digest();
    }

    public static void writeToDB(String filePath, String md5) {
        if ((id = isBeFound(md5)) > 0) {
            handle_1(filePath, id);
            return;
        }
        handle_2(filePath, md5);
    }

    public static int isBeFound(String md5) {
        String sql = "select * from fileinfo where hash=?";
        fileinfoBean fileinfo;
        try {
            fileinfo = qr.query(sql, new BeanHandler<fileinfoBean>(fileinfoBean.class), md5);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        if (fileinfo != null) {
            return fileinfo.getId();
        }
        return 0;
    }

    public static void handle_1(String filePath, int id) {
        String sql_1 = "select * from fileinfo where id=?";
        String sql_2 = "update fileinfo set path=?,count=? where id=?";
        fileinfoBean fileinfo = null;
        try {
            fileinfo = qr.query(sql_1, new BeanHandler<fileinfoBean>(fileinfoBean.class), id);

            fileinfo.setPath(fileinfo.getPath() + ";" + filePath);
            fileinfo.setCount(fileinfo.getCount() + 1);

            Object[] params = {fileinfo.getPath(), fileinfo.getCount(), id};
            qr.update(sql_2, params);

        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void handle_2(String filePath, String md5) {
        String sql = "insert into fileinfo(path,hash,count) values (?,?,?)";
        Object[] params = {filePath, md5, 1};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void function_1() {
        String sql = "select count(hash) as num from fileinfo";
        countBean countBean = new countBean();
        try {
            countBean = qr.query(sql, new BeanHandler<countBean>(countBean.class));
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        System.out.println("该磁盘分区中有" + countBean.getNum() + "个不同的PE文件");
    }

    public static void function_2() {
        String sql = "select path from fileinfo where count in (select max(count) from fileinfo)";
        ArrayList<fileinfoBean> pathList = new ArrayList<fileinfoBean>();
        try {
            pathList.addAll(qr.query(sql, new BeanListHandler<fileinfoBean>(fileinfoBean.class)));
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        System.out.println("出现次数最多的PE文件的路径名序列：");
        for (fileinfoBean fileinfo : pathList) {
            System.out.println(fileinfo.getPath().replaceAll(";{1}", "\t"));
        }
    }
}
