package com.designPatterns.observer;

public class Main {
    public static void main(String[] args) {
        ProductList observable=ProductList.getInstance();

        TaoBaoObserver taoBaoObserver=new TaoBaoObserver();
        JingDongObserver jingDongObserver=new JingDongObserver();

        observable.addObserver(taoBaoObserver);
        observable.addObserver(jingDongObserver);

        observable.addProudct("新增产品1");
    }
}
