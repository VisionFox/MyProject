package com.netProject.UDPChartPlus;

import java.io.IOException;
import java.net.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DatagramSend {
    private InetAddress localAddr;
    private DatagramSocket dSender;
    private InetAddress destAddr;
    private int sendPort;

    private Scanner sc=new Scanner(System.in);

    Map<Integer, SendMsg> msgQueue = new ConcurrentHashMap<Integer, SendMsg>();

    public DatagramSend() throws SocketException, UnknownHostException {
        this.localAddr = InetAddress.getByName("127.0.0.1");
        this.destAddr = InetAddress.getByName("192.168.84.135");

        //本机发送UDP端口
        this.sendPort = 7123;

        dSender = new DatagramSocket(this.sendPort);

        startSendThread();
        startRecvResponseThread();
        startReSendThread();
    }

    public void startSendThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    send();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void send() throws IOException, InterruptedException {
        System.out.println("发送端-发送数据线程启动。。。");
        int id = 0;
        while (true) {
            id++;

//            String scMsg=sc.nextLine();
            byte[] msgData = ("第"+id+"条数据：" + "-helloword").getBytes();

            SendMsg sendMsg = new SendMsg(id, msgData);

            byte[] buffer = sendMsg.toByte();

            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, this.destAddr,7124);

            dSender.send(dp);

            sendMsg.setSendCount(1);
            sendMsg.setLastSendTime(System.currentTimeMillis());
            sendMsg.setRecvRespAddr(this.localAddr);
            sendMsg.setDestAddr(this.destAddr);

            msgQueue.put(id, sendMsg);
            System.out.println("发送端-数据已发送" + sendMsg);
            Thread.sleep(10);
        }
    }

    public void startRecvResponseThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    recvResponse();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void recvResponse() throws IOException {
        System.out.println("发送端--接收应答线程启动....");
        while (true) {
            byte[] recvData = new byte[100];

            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);

            dSender.receive(recvPacket);

            ResponMsg resp = new ResponMsg(recvPacket.getData());

            int respID = resp.getRepId();
            SendMsg msg = msgQueue.get(new Integer(respID));

            if (msg != null) {
                System.out.println("发送端-已收到应答ACK信息：" + msg);
                msgQueue.remove(respID);
            }
        }
    }

    public void startReSendThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        resendMsg();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }).start();
    }

    public void resendMsg() {
        Set<Integer> keyset = msgQueue.keySet();
        Iterator<Integer> it = keyset.iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            SendMsg msg = msgQueue.get(key);

            if (msg.getSendCount() > 3) {
                it.remove();
                System.out.println("====发送端---检测到丢失信息" + msg);
            }

            long cTime = System.currentTimeMillis();
            //100
            if ((cTime - msg.getLastSendTime()) > 100 && msg.getSendCount() < 3) {
                byte[] buffer = msg.toByte();
                try {
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length, msg.getDestAddr(), 7124);
                    dSender.send(dp);

                    msg.setSendCount(msg.getSendCount() + 1);
                    System.out.println("客户端--重发消息：" + msg);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) throws SocketException, UnknownHostException {
        new DatagramSend();
    }

}
