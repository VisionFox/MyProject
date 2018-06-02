package com.designPatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.out.println("京东发现新品：" + newProduct);
    }
}
