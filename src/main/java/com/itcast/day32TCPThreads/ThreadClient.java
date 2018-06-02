package com.itcast.day32TCPThreads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8000);
        OutputStream outputStream=socket.getOutputStream();
        FileInputStream fileInputStream=new FileInputStream("E:\\TCPtest.jpg");
        byte[] data=new byte[1024];
        int len=0;
        while ((len=fileInputStream.read(data))!=-1){
            outputStream.write(data,0,len);
        }
        socket.shutdownOutput();//给server端带去终止信息
        InputStream inputStream= socket.getInputStream();
        len=inputStream.read(data);
        System.out.println(new String(data,0,len));

        fileInputStream.close();
        socket.close();
    }
}
