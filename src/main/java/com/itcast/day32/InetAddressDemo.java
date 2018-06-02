package com.itcast.day32;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet=InetAddress.getLocalHost();
        System.out.println(inet);
    }

    public static void function_1() throws UnknownHostException {
        InetAddress inet=InetAddress.getByName("www.fuck.com");
        System.out.println(inet);
    }

    public static void function_2() throws UnknownHostException {
        InetAddress inet=InetAddress.getLocalHost();
        System.out.println(inet);
    }
}
