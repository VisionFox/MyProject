package com.itcast.day20homwork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Student,String> hmap=new HashMap<Student,String>();
        hmap.put(new Student("a",1),"zhu1");
        hmap.put(new Student("b",1),"zhu2");
        hmap.put(new Student("c",1),"zhu3");
        hmap.put(new Student("d",1),"zhu4");
        function_2(hmap);
    }
    public static void function_2(Map<Student,String> hmap){
        Set<Student> set=hmap.keySet();
        Iterator<Student> it=set.iterator();
        while (it.hasNext()){
            System.out.println(hmap.get(it.next()));
        }
    }


    public static void function_1(Map<Student,String> hmap){
        for (Map.Entry<Student,String> entry:hmap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
