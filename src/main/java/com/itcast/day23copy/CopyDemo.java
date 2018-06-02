package com.itcast.day23copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args){
        long start=System.currentTimeMillis();
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream("D:\\rr.txt");
            fos=new FileOutputStream("D:\\BaiduYunDownload\\北京黑马基础班\\解压\\day24\\day24_video\\rr.txt");
            byte[] bytes=new  byte[1024*10];
            int len=0;
            while ((len=fis.read(bytes))!=-1){//忘记在read里写bytes坑点还有就是把-1写成零
                fos.write(bytes,0,len);
            }
        }catch (IOException ex){
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                if (fos!=null)
                    fos.close();
            }catch (IOException ex){
                System.out.println(ex);
                throw new RuntimeException("关闭输出流失败");
            }finally {
                try {
                    if (fis!=null)
                        fis.close();
                }catch (IOException ex){
                    System.out.println(ex);
                    throw new RuntimeException("关闭输入流失败");
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start+"毫秒");
    }
}
