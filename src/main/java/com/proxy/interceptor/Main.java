package com.proxy.interceptor;

public class Main {
    public static void main(String[] args) {
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        HelloWorldImpl_2 proxy = (HelloWorldImpl_2) cglibProxyExample.getProxy(HelloWorldImpl_2.class);
        proxy.sayHello("jack");
    }
}
