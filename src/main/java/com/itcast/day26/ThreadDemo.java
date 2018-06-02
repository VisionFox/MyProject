package com.itcast.day26;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {



        //第一种
        RunnableDemo rd=new RunnableDemo();
        Thread runnable=new Thread(rd);
        runnable.start();

        //第二种
        ExtendsThreadDemo et=new ExtendsThreadDemo();
        et.start();

        //第三种
        new Thread(){
            public void run(){
                for (int i=0;i<10;++i){
                    System.out.println("匿名内部类的线程： "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //第四种
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;++i){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runable的内部类实现："+i);
                }
            }
        };
        Thread rt=new Thread(r);
        rt.start();
        //第五种
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;++i){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("runable的内部类实现(放进new thread)："+i);
                }
            }
        }).start();

        for (int i=0;i<10;++i){
            Thread.sleep(1000);
            System.out.println("main----"+i);
        }
    }
}
