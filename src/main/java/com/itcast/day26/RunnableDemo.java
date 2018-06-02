package com.itcast.day26;

public class RunnableDemo implements Runnable{
    public void run(){
        for (int i=0;i<10;++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable----"+i);
        }
    }
}
