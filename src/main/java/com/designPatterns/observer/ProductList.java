package com.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    private List<String> productList = new ArrayList<String>();

    //用到单例模式;双重校验锁
    private static ProductList instance;

    public static ProductList getInstance() {
        if (instance == null) {
            synchronized (ProductList.class) {
                if (instance == null) {
                    instance = new ProductList();
                }
            }
        }
        return instance;
    }

    /**
     * 增加哦观察者
     *
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProudct(String newProduct){
        productList.add(newProduct);
        System.out.println("add: "+newProduct);
        //设置被观察对象发生了变化
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(newProduct);

    }
}
