package com.itcast.day26ThreadPoolDemo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(2);
        ThreadPoolCallable callable_1= new  ThreadPoolCallable();
        ThreadPoolCallable callable_2= new  ThreadPoolCallable();
        Future<String> f1= es.submit(callable_1);
        Future<String> f2= es.submit(callable_2);

        String s1= f1.get();
        String s2= f2.get();
        System.out.println(s1);
        System.out.println(s2);

    }
}
