package com.netProject.TCPFileTransport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws IOException {
        send();
    }

    public static void send() throws IOException {
        Socket socket=new Socket("192.168.84.135",7878);
        SendRunnable sendRunnable=new SendRunnable(socket,"F:\\TCPtest.jpg");
        new Thread(sendRunnable).start();
    }

    public static void accept() throws IOException {
        ServerSocket serverSocket=new ServerSocket(7878);
        while (true){
            Socket socket= serverSocket.accept();
            new Thread(new AcceptRunnable(socket,"F:\\TCPUpload")).start();
        }
    }
}
