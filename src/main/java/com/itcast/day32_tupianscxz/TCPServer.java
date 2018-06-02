package com.itcast.day32_tupianscxz;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8000);
        Socket socket=serverSocket.accept();
        InputStream in=socket.getInputStream();
        File upload=new File("F:\\TCPupload");
        if (!upload.exists()){
            upload.mkdirs();
        }
        //防止重名被覆盖：自定义命名规则
        String filename="itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
        //分隔符跨平台
        FileOutputStream fos=new FileOutputStream(upload+File.separator+filename);
        byte[] data=new  byte[1024];
        int len=0;
        //下面的read很容易收不到结束标志而阻塞死等
        while ((len=in.read(data))!=-1){
            fos.write(data,0,len);
        }

        socket.getOutputStream().write("上传成功".getBytes());
        fos.close();
        socket.close();
        serverSocket.close();

    }
}
