package com.itcast.day24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriteDemo {
    public static void main(String[] args) throws IOException {
        function_1();
    }
    public static void function_1()throws IOException{
        FileOutputStream fos=new FileOutputStream("D:\\BaiduYunDownload\\北京黑马基础班\\解压\\day24\\day24_video\\rr.txt");
        OutputStreamWriter os=new OutputStreamWriter(fos,"UTF-8");
        os.write("你好");
        os.flush();
        os.close();
    }
}
