package com.itcast.day32_tupianscxz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8000);
        OutputStream out= socket.getOutputStream();
        FileInputStream fis=new FileInputStream("E:\\TCPtest.jpg");
        byte[] data=new byte[1024];
        int len=0;

        while ((len=fis.read(data))!=-1){
            out.write(data,0,len);
        }
        socket.shutdownOutput();//告诉服务端停止输出流，防止服务端的read收不到终止标志而死等阻塞着

        InputStream in= socket.getInputStream();
        len= in.read(data);
        System.out.println(new String(data,0,len));

        fis.close();
        socket.close();
    }
}
