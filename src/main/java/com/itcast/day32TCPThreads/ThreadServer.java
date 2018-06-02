package com.itcast.day32TCPThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ThreadUpload(socket)).start();
        }
    }
}
