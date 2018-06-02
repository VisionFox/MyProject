package com.itcast.day25;

import java.io.Serializable;

public class Person implements Serializable{
    String name;
    int age;
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    static final long serialVersionUID = 10000000L;//绑定UID防止修改类的源码后无法反序列
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
