package com.itcast.day32TCPThreads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

public class ThreadUpload implements Runnable {
    private Socket socket;
    public ThreadUpload(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();
            File upload=new File("F:\\TCPUpload");
            if (!upload.exists()){
                upload.mkdirs();
            }

            String filename="itcast"+System.currentTimeMillis()+
                    new Random().nextInt(999999)+ ".jpg";

            FileOutputStream fileOutputStream=new FileOutputStream(upload+File.separator+filename);
            byte[] data=new byte[1024];
            int len=0;

            while ((len=inputStream.read(data))!=-1){
                fileOutputStream.write(data,0,len);
            }
            socket.getOutputStream().write("上传完毕".getBytes());

            fileOutputStream.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("上传失败");
        }
    }
}
