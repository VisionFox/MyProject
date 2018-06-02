package com.itcast.day32;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String message;
        //InetAddress inet=InetAddress.getByName("192.168.84.1");//mywindows
        //InetAddress inet=InetAddress.getByName("192.168.84.135");//myCentos
       // InetAddress inet=InetAddress.getByName("10.177.153.128");//xiaozhi
        InetAddress inet=InetAddress.getByName("10.177.70.251");//myCentos

        DatagramSocket ds=new DatagramSocket();
        while (true){
            message=sc.nextLine();
            byte[] data=message.getBytes();//将键盘输入的信息打包成字节数组
            DatagramPacket dp=new DatagramPacket(data,data.length,inet,6000);//将字节数据打包成数据报
            ds.send(dp);
        }
    }
}
