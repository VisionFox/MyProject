package com.itcast.day32_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        //调用服务器套接字对象中的方法accept（）获取客户端套接字对象，可以辨认是哪一个客户端
        Socket socket=serverSocket.accept();
        InputStream in= socket.getInputStream();
        byte[] data=new byte[1024];
        int len=in.read(data);
        System.out.println(new String(data,0,len));

        OutputStream os= socket.getOutputStream();
        os.write("收到谢谢，我是服务端".getBytes());

        socket.close();
        serverSocket.close();
    }
}
