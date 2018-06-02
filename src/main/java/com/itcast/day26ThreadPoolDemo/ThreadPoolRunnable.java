package com.itcast.day26ThreadPoolDemo;

public class ThreadPoolRunnable implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"提交给线程池的任务");
    }
}
