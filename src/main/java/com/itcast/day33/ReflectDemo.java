package com.itcast.day33;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("com.itcast.day33.Person");
        //获取有公共权限的构造器
        Constructor[] cons= c.getConstructors();
        for (Constructor con : cons){
            System.out.println(con);
        }

        Constructor con= c.getConstructor();
        Object obj= con.newInstance();
        System.out.println(obj);

        Constructor con1= c.getConstructor(String.class,int.class);
        Object obj1= con1.newInstance("wokk",99);
        System.out.println(obj1);

    }
}
