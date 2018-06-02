package com.itcast.day23TxtCopy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class day23TxtCopy {
    public static void main(String[] args) {
        function_2();
    }
    public static void function_2(){
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("D:\\rr.txt");
            fw = new FileWriter("D:\\BaiduYunDownload\\北京黑马基础班\\解压\\day24\\day24_video\\rr.txt");
            char[] cbuf = new char[1024];
            int len = 0 ;
            while(( len = fr.read(cbuf))!=-1){
                fw.write(cbuf, 0, len);
                fw.flush();
            }

        }catch(IOException ex){
            System.out.println(ex);
            throw new RuntimeException("复制失败");
        }finally{
            try{
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                throw new RuntimeException("释放资源失败");
            }finally{
                try{
                    if(fr!=null)
                        fr.close();
                }catch(IOException ex){
                    throw new RuntimeException("释放资源失败");
                }
            }
        }
    }

    public static void function_1(){
        FileReader fr=null;
        FileWriter fw=null;
        try {
            fr=new FileReader("D:\\rr.txt");
            fw=new FileWriter("D:\\BaiduYunDownload\\北京黑马基础班\\解压\\day23\\day23_video\\test.txt");
            int len=0;
            char[] ch=new char[1024];
            while ((len=fr.read(ch))!=-1){
                fw.write(ch,0,len);
                fw.flush();
            }
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("传输失败");
        }finally {
            try {
                if (fw!=null)
                    fw.close();
            }catch (IOException e){
                System.out.println(e);
                throw new RuntimeException("释放资源失败");
            }finally {
                try {
                    if (fr!=null)
                        fr.close();
                }catch (IOException e){
                    System.out.println(e);
                    throw new RuntimeException("释放资源失败");
                }
            }
        }


    }
}