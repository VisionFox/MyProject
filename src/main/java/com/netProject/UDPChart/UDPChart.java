package com.netProject.UDPChart;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPChart {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        Receive receive=new Receive(7123);
//        Send send=new Send(InetAddress.getByName("10.177.248.232"),7124);
        Send send=new Send(InetAddress.getByName("192.168.84.135"),7124);

        Thread rt=new Thread(receive);
        Thread st=new Thread(send);

        rt.start();
        st.start();
    }
}
