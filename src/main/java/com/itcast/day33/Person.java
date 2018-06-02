package com.itcast.day33;

public class Person {
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
//    static {
//        System.out.println("person的静态代码块");
//    }
    String name;
    int age;


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"  "+age;
    }
}
