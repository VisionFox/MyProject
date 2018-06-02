package com.proxy.base;

import com.proxy.base.LdhProxy;
import com.proxy.base.Person;

public class Test {
    public static void main(String[] args) {
        LdhProxy proxy = new LdhProxy();
        Person p = proxy.getProxy();

        String retValue = p.sing();
        System.out.println(retValue + "kkkk");
        //调用代理对象的dance方法
        String value = p.dance();
        System.out.println(value + "llll");
    }
}
