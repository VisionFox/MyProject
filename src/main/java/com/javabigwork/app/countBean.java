package com.javabigwork.app;

public class countBean {
    private int num;

    public countBean(int num) {
        this.num = num;
    }

    public countBean() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "countBean{" +
                "num=" + num +
                '}';
    }
}
