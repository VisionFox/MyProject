package com.itcast.day27ThreadDemo;

public class Test {
    public static void main(String[] args) {
        Resource re =new  Resource();
        Input input=new Input(re);
        Output output=new Output(re);

        Thread t1=new Thread(input);
        Thread t2=new Thread(output);
        t1.start();
        t2.start();
    }
}
