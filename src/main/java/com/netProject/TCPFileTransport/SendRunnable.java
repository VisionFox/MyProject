package com.netProject.TCPFileTransport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendRunnable implements Runnable {
    private Socket socket;
    private String filePath;

    public SendRunnable(Socket socket,String filePath) {
        this.socket = socket;
        this.filePath=filePath;
    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            FileInputStream in = new FileInputStream(this.filePath);
            byte[] dataBuff = new byte[1024];
            int len = 0;

            while ((len = in.read(dataBuff)) != -1) {
                out.write(dataBuff, 0, len);
            }
            socket.shutdownOutput();

            len = socket.getInputStream().read(dataBuff);
            System.out.println(new String(dataBuff,0,len));

            in.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("文件发送失败");
        }
    }
}
