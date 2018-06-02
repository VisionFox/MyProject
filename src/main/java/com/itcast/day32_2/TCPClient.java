package com.itcast.day32_2;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        OutputStream os= socket.getOutputStream();
        os.write("nihao我是客户端".getBytes());

        InputStream in=socket.getInputStream();
        byte[] data=new byte[1024];
        int len= in.read(data);
        System.out.println(new String(data,0,len));

        socket.close();
    }
}
