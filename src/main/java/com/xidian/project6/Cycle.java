package com.xidian.project6;

public class Cycle {
    public void ride() {
        System.out.println("这是被 "+this.getClass().getName()+" 实例化的对象，有"+this.wheel()+"个轮子");

        if(this instanceof Unicycle){
            Unicycle unicycle=(Unicycle)this;
            unicycle.balance();
        }

        if(this instanceof Bicycle){
            Bicycle bicycle=(Bicycle)this;
            bicycle.balance();
        }
    }

    public int wheel() {
        return  0;
    }
}
