package com.netProject.UDPChartPlus;

import java.io.IOException;
import java.net.*;

/**
 * UDP的接收端
 */
public class DatagramRecive {
    private SocketAddress localAddr;
    private DatagramSocket dsender;

    public DatagramRecive() throws SocketException {
        localAddr = new InetSocketAddress("127.0.0.1", 14000);
        dsender = new DatagramSocket(localAddr);

        startRecvThread();
    }

    public void startRecvThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    recvMsg();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void recvMsg() throws IOException {
        System.out.println("接收线程启动");
        while (true) {
            byte[] recvData = new byte[100];
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
            dsender.receive(recvPacket);

            SendMsg recvMsg = new SendMsg(recvPacket.getData());
            ResponMsg resp = new ResponMsg(recvMsg.getId(), (byte) 0, System.currentTimeMillis());

            byte[] data = resp.toByte();
            DatagramPacket dp = new DatagramPacket(data, data.length, recvPacket.getSocketAddress());

            dsender.send(dp);

            System.out.println("接收端--已发送应答" + resp);
        }
    }

    public static void main(String[] args) throws SocketException {
        new DatagramRecive();
    }
}
