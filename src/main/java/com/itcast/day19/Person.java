package com.itcast.day19;

public class Person {
    //构造器
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    //成员变量
    private String name;
    private int age;

    //getter和setter方法
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
    //重写toString方法
    @Override
    public String toString() {
        return "名字: "+this.name+" 年龄： "+this.age;
    }

    //重写hash中的hashCode和equals方法，使内容相同的类不能重复写入set
    public int hashCode(){
        return this.name.hashCode()+this.age*128;
    }

    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            Person p=(Person) obj;
            return p.age==this.age && this.name.equals(p.name);
        }
        return  false;
    }
}
