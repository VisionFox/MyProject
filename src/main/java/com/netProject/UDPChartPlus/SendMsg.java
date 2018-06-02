package com.netProject.UDPChartPlus;

import java.io.*;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Arrays;

public class SendMsg {
    private int totalLen;
    private int id;
    private byte[] data;

    private InetAddress recvRespAddr;
    private InetAddress destAddr;

    private int sendCount = 0;
    private long lastSendTime;

    public SendMsg(int id, byte[] data) {
        this.id = id;
        this.data = data;
        totalLen = 4 + 4 + data.length;
    }

    public SendMsg(byte[] udpData) {
        ByteArrayInputStream bins = new ByteArrayInputStream(udpData);
        DataInputStream dins = new DataInputStream(bins);


        try {
            this.totalLen = dins.readInt();
            this.id = dins.readInt();

            this.data = new byte[totalLen - 4 - 4];
            dins.readFully(data);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public byte[] toByte() {
        ByteArrayOutputStream bous = new ByteArrayOutputStream();
        DataOutputStream dous = new DataOutputStream(bous);

        try {
            dous.writeInt(totalLen);
            dous.writeInt(id);
            dous.write(data);

            dous.flush();

            return bous.toByteArray();
        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public String toString() {
        return "SendMsg{" +
                "totalLen=" + totalLen +
                ", id=" + id +
                ", data=" + Arrays.toString(data) +
                ", recvRespAddr=" + recvRespAddr +
                ", destAddr=" + destAddr +
                ", sendCount=" + sendCount +
                ", lastSendTime=" + lastSendTime +
                '}';
    }

    public int getTotalLen() {
        return totalLen;
    }

    public void setTotalLen(int totalLen) {
        this.totalLen = totalLen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public InetAddress getRecvRespAddr() {
        return recvRespAddr;
    }

    public void setRecvRespAddr(InetAddress recvRespAddr) {
        this.recvRespAddr = recvRespAddr;
    }

    public InetAddress getDestAddr() {
        return destAddr;
    }

    public void setDestAddr(InetAddress destAddr) {
        this.destAddr = destAddr;
    }

    public int getSendCount() {
        return sendCount;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public long getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }
}