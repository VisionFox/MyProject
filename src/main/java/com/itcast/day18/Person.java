package com.itcast.day18;

public class Person {
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    private String name;

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

    private int age;

    public String toString(){
        return "名字: "+this.name+"  年龄："+this.age;
    }
}
