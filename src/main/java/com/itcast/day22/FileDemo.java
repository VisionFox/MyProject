package com.itcast.day22;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
        File[] roots= File.listRoots();
        for (File root: roots){
            checkAllFile(root);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void checkAllFile(File root){
        File[] fileArr=root.listFiles();
        if (fileArr==null) return;
        for (File file:fileArr){
            if (file.isDirectory()){
                checkAllFile(file);
            }else {
                System.out.println(file);
            }
        }

    }

    public static void function_1() throws IOException {
        File l=new File("F:\\test\\新建文本文档");
        boolean b= l.delete();
        System.out.println(b);
    }

}
