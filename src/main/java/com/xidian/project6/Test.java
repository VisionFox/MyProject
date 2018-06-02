package com.xidian.project6;

public class Test {
    public static void main(String[] args) {
        Cycle unicycle = new Unicycle();
        Cycle bicycle = new Bicycle();
        Cycle tricycle = new Tricycle();

        unicycle.ride();
        System.out.println();

        bicycle.ride();
        System.out.println();

        tricycle.ride();
    }
}
