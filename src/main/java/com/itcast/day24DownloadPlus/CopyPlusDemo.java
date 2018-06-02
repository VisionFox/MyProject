package com.itcast.day24DownloadPlus;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyPlusDemo {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        BufferedInputStream bfis=null;
        BufferedOutputStream bfos=null;
        int len = 0;
        byte[] bytes=new byte[1024*2];
        long start=System.currentTimeMillis();
        try {
            fis=new FileInputStream("D:\\javatest.zip");
            fos=new FileOutputStream("D:\\BaiduYunDownload\\北京黑马基础班\\解压\\day24\\day24_video\\javatest.zip");
            bfis=new BufferedInputStream(fis);
            bfos=new BufferedOutputStream(fos);
            while ((len=bfis.read(bytes))!=-1){
                bfos.write(bytes,0,len);
            }
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("拷贝失败");
        }finally {
           try {
               if(bfos!=null && fos!=null){
                   bfos.close();
                   fos.close();
               }
           }catch (IOException e){
               System.out.println(e);
               throw new RuntimeException("释放资源失败");
           }finally {
               try {
                   if(bfis!=null && fis!=null){
                       bfis.close();
                       fis.close();
                   }
               }catch (IOException e){
                   System.out.println(e);
                   throw new RuntimeException("释放资源失败");
               }
           }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"毫秒");
    }
}
