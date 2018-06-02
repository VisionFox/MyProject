package com.test.pkg1;

public class A {
    public A() {
        System.out.println("A's constructor");
    }

    void mtd() {
        System.out.println("A's method");
    } //mtd()为包权限
}

class B {//B为包权限

    public B() {
        System.out.println("B's constructor");
    }
}
