package com.itcast.day32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(6000);
        byte[] data=new byte[1024];
        DatagramPacket dp=new DatagramPacket(data,data.length);

        while (true) {
            ds.receive(dp);//接收数据报
            int lenth = dp.getLength();//收到数据的长度
            InetAddress ip = dp.getAddress();//获取数据报发送方的ip地址
            int port = dp.getPort();//获取发送方的端口
            System.out.println(new String(data, 0, lenth) + "--------发送方的ip为：" + ip + " 发送方的发送端口为：" + port);
        }
    }
}
