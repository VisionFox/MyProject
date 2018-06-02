package com.xidian.project6;

public class Bicycle extends Cycle {
    public int wheel() {
        return 2;
    }

    public void balance(){
        System.out.println("这是Bicycle独有的balance方法");
    }
}
