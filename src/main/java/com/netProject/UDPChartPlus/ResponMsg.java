package com.netProject.UDPChartPlus;

import java.io.*;

public class ResponMsg {
    private int totalLen;
    private int repId;
    private byte state = 0;//状态0接收正确
    private long resTime;

    public ResponMsg(int repId, byte state, long resTime) {
        this.repId = repId;
        this.state = state;
        this.resTime = resTime;
        this.totalLen = 4 + 4 + 1 + 8;
    }

    public ResponMsg(byte[] udpData) {
        ByteArrayInputStream bins = new ByteArrayInputStream(udpData);
        DataInputStream dins = new DataInputStream(bins);

        try {
            this.totalLen = dins.readInt();
            this.repId = dins.readInt();
            this.state = dins.readByte();
            this.resTime = dins.readLong();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public byte[] toByte() {
        ByteArrayOutputStream bous = new ByteArrayOutputStream();
        DataOutputStream dous = new DataOutputStream(bous);

        try {
            dous.writeInt(this.totalLen);
            dous.writeInt(this.repId);
            dous.writeByte(this.state);
            dous.writeLong(this.resTime);
            dous.flush();

            return bous.toByteArray();

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ResponMsg{" +
                "totalLen=" + totalLen +
                ", repId=" + repId +
                ", state=" + state +
                ", resTime=" + resTime +
                '}';
    }

    public int getTotalLen() {
        return totalLen;
    }

    public void setTotalLen(int totalLen) {
        this.totalLen = totalLen;
    }

    public int getRepId() {
        return repId;
    }

    public void setRepId(int repId) {
        this.repId = repId;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public long getResTime() {
        return resTime;
    }

    public void setResTime(long resTime) {
        this.resTime = resTime;
    }
}
