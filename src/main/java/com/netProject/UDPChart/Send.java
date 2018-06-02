package com.netProject.UDPChart;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Send implements Runnable {
    private InetAddress inet;
    private Scanner sc=new Scanner(System.in);
    private int port;
    private DatagramSocket datagramSocket=new DatagramSocket();

    public Send(InetAddress inet,int port) throws SocketException {
        this.inet=inet;
        this.port=port;
    }

    public void run() {
        while (true){
            String message=sc.nextLine();
            byte[] dataBuff=message.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(dataBuff,dataBuff.length,this.inet,this.port);
            try {
                this.datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                System.out.println(e);
                throw new RuntimeException("udp数据报发送失败");
            }
        }
    }
}
