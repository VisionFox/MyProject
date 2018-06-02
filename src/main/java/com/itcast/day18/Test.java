package com.itcast.day18;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        function_7();
    }

    public static void function_7(){
        Collection<String> a=new ArrayList<String>();
        Collection<Integer> b=new HashSet<Integer>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");

        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);

        Iterator<?> it1=a.iterator();
        Iterator<?> it2=b.iterator();

        while (it1.hasNext()){
            System.out.println(it1.next());
        }
        while (it2.hasNext()){
            System.out.println(it2.next());
        }

    }

    public static void function_1(){
        ArrayList<Person> arr=new ArrayList<Person>();
        arr.add(new Person("a",2));
        arr.add(new Person("b",21));
        arr.add(new Person("c",211));
        arr.add(new Person("d",2111));
        for (int i=0;i<arr.size();++i){
            System.out.println(arr.get(i));
        }
    }

    public static void function_2(){
        int[] a={1,2,3,4,5};
        System.out.println((Arrays.toString(a)));
    }

    public static void function_3(){
        Collection<String> array=new ArrayList<String>();
        array.add("a");
        array.add("b");
        array.add("c");
        Object[] a=array.toArray();
        System.out.println(Arrays.toString(a));
    }

    public static void function_4(){
        Collection<String> array=new ArrayList<String>();
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("c");
        System.out.println(array);
        System.out.println("请输入要删除的元素：");
        Scanner Sc=new Scanner(System.in);
        String s=Sc.next();
        if(array.remove(s)){
            //只删除第一个遇到的数据
            System.out.println("删除成功");
            System.out.println(array);
        }else {
            System.out.println("删除失败");
        }
    }

    public static void function_5(){
        ArrayList<String> coll=new ArrayList<String>();
        coll.add("a");
        coll.add("b");
        coll.add("c");
        Iterator<String> it=coll.iterator();
        while (it.hasNext()){
            String s=it.next();//假如Iterator<String>里没有String此行错误
            System.out.println(s );
        }
    }

    public static void function_6(){
        Collection every =new ArrayList();//不加类型什么都可以往里添加，但拿出的都是向上转型的object类型有些功能需要想下转型
        every.add(123);
        every.add("eee");
        every.add(new Person("qqq",90));

        System.out.println(every.toString());

        for (Iterator it=every.iterator();it.hasNext(); ){
            System.out.println(it.next());
        }
    }
}
