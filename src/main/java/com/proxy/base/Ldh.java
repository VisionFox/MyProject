package com.proxy.base;

public class Ldh implements Person {

    @Override
    public String sing() {
        System.out.println("ldh sing wan");
        return "sing";
    }

    @Override
    public String dance() {
        System.out.println("ldh dance wan");
        return "dance";
    }
}
