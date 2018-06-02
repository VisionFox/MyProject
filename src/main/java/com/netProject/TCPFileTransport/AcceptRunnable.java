package com.netProject.TCPFileTransport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

public class AcceptRunnable implements Runnable {
    private Socket socket;
    private String AcceptFolderPath;
    public AcceptRunnable(Socket socket,String AcceptFolderPath){
        this.socket=socket;
        this.AcceptFolderPath=AcceptFolderPath;
    }


    @Override
    public void run() {
        try {
            InputStream in=socket.getInputStream();

            File AcceptFolder=new File(this.AcceptFolderPath);
            if (!AcceptFolder.exists()){
                AcceptFolder.mkdirs();
            }

            String fileName="Accept"+System.currentTimeMillis()+new Random().nextInt(1000)+".jpg";
            FileOutputStream out=new FileOutputStream(AcceptFolder+File.separator+fileName);
            int len=0;
            byte[] dataBuff=new byte[1024];

            while ((len=in.read(dataBuff))!=-1){
                out.write(dataBuff,0,len);
            }

            socket.getOutputStream().write("传输完成".getBytes());

            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("接收文件失败");
       }
    }
}
