package com.xidian.project6;

public class Unicycle extends Cycle {
    public int wheel() {
        return 1;
    }

    public void balance(){
        System.out.println("这是Unicycle独有的balance方法");
    }
}
