package com.reflect;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        ReflectServiceImpl2 reflectService = new Main().getInstance2();
        reflectService.sayHello();
    }

    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl obj = null;

        try {
            obj = (ReflectServiceImpl) Class.forName("com.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public ReflectServiceImpl2 getInstance2() {
        ReflectServiceImpl2 obj = null;

        try {
            obj = (ReflectServiceImpl2) Class.forName("com.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("zhangsan");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
