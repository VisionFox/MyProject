package com.itcast.day26yibujisuan;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(2);
        Future<Integer> f1= es.submit(new GetSumCallable(100));
        Future<Integer> f2= es.submit(new GetSumCallable(200));
        System.out.println(f1.get());
        System.out.println(f2.get());
        es.shutdown();
    }
}
