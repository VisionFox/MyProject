package com.itcast.day26;

public class ExtendsThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ExtendsThreads----"+i);
        }
    }
}
