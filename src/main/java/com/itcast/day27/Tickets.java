package com.itcast.day27;

public class Tickets implements Runnable{
    private int tickets=100;
    @Override
    public void run() {
        while (true){
            if (tickets>0){
                System.out.println(Thread.currentThread().getName()+"卖出第"+(tickets--)+"张票");
//                try {
//                    Thread.sleep(60);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else{
                break;
            }
        }
    }
}
