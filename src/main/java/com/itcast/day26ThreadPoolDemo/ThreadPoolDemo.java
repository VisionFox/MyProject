package com.itcast.day26ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //day26_21很值得研究
        ExecutorService es =Executors.newFixedThreadPool(2);//返回的是ExecutorService（接口）的实现类
        ThreadPoolRunnable runnable_1=new  ThreadPoolRunnable();
        ThreadPoolRunnable runnable_2=new  ThreadPoolRunnable();
        es.submit(runnable_1);
        es.submit(runnable_2);
        //es.shutdown();
    }
}
