package com.itcast.day26ThreadPoolDemo2;

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String> {
    public String call(){
        System.out.println("callable的call方法");
        return "abcdefg";
    }
}
