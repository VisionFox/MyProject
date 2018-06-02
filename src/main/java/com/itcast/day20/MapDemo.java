package com.itcast.day20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
//        int sum=getSum(1,23,4,5,6,7,89,6,5,3,3,2,2,32,4,25,2,53,5,532,532,35,532,532,53,53,532,532);
//        System.out.println(sum);
    }

    public static int getSum(int...a){
        int sum=0;
        for (int i : a){
            sum+=i;
        }
        return sum;
    }

    public static void function_2(){
        Map<Integer,String> m=new HashMap<Integer, String>();
        m.put(1,"a");
        m.put(2,"b");
        m.put(3,"c");
        System.out.println(m);
        //迭代器遍历
        Set<Map.Entry<Integer,String>> set=m.entrySet();
        Iterator<Map.Entry<Integer,String>> it=set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry=it.next();
            Integer a1=entry.getKey();
            String a2=entry.getValue();
            System.out.println("key:  "+a1+"  value:  "+a2);
        }
        System.out.println("=======================================================");

        //增强for
        for(Map.Entry<Integer,String> entry : m.entrySet()){
            System.out.println("key:  "+entry.getKey()+"  value:  "+entry.getValue());
        }

    }

    public static void function_1(){
        Map<String ,Integer> m=new HashMap<String, Integer>();
        m.put("a",1);
        m.put("b",2);
        m.put("c",3);

        System.out.println(m);
    }
}
