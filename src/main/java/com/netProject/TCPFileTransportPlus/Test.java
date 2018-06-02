package com.netProject.TCPFileTransportPlus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {
        send();
    }

    public static void send() throws IOException {
        Socket socket=new Socket("192.168.84.135",7878);
//        Properties properties=new Properties();


        BreakPointSend breakPointSend=new BreakPointSend(socket,"F:\\bigTCPTest.zip");
        new Thread(breakPointSend).start();
    }
}
