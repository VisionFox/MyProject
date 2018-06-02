package com.netProject.UDPChart;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive implements Runnable {
    byte[] dataBuff = new byte[1024];
    DatagramSocket datagramSocket;
    DatagramPacket datagramPacket = new DatagramPacket(dataBuff,dataBuff.length);

    public Receive(int port) throws SocketException {
        datagramSocket=new DatagramSocket(port);
    }

    public void run() {
        while (true) {
            try {
                datagramSocket.receive(datagramPacket);
                int infoLen = datagramPacket.getLength();
                System.out.println(new String(dataBuff, 0, infoLen)
                        + "     ip:" + datagramPacket.getAddress()
                        + "     port:" + datagramPacket.getPort());
            } catch (IOException e) {
                System.out.println(e);
                throw new RuntimeException(Thread.currentThread().getName() + "wrong");
            }
        }
    }
}
