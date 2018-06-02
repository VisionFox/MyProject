package com.itcast.day27ThreadDemo;

public class Input implements Runnable {
    private Resource r;
    public Input(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        int i=0;
        while (true){
            synchronized (r){
                if (r.flag){
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i%2==0){
                    r.name="张三";
                    r.sex="男";
                }else {
                    r.name="lili";
                    r.sex="nv";
                }
                ++i;
                r.flag=true;
                r.notify();
            }
        }
    }
}
