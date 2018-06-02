package com.itcast.day23;

import java.io.*;

public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("E:\\a.txt");
        FileInputStream fis=new FileInputStream(file);
        byte[] b=new byte[1024];//空间可以自由开但1024个字节或者1024的整数倍，折中开辟最好
        int len=0;
        while ((len=fis.read(b))!=-1){//len获得的（read返回的是int）是read到的 有效字节 的个数
            System.out.println(new String(b,0,len));//以防数据读完，还有剩余空间，会打印出多余的无效字符
        }
        fis.close();
    }
}
