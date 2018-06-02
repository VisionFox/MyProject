package com.itcast.day19;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        homeWork();
    }

    public static void homeWork() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("f");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("d");
        HashSet<String> hs = new HashSet<String>();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            hs.add(it.next());
        }
        list.clear();
        for (Iterator<String> it = hs.iterator(); it.hasNext(); ) {
            list.add(it.next());
        }

        System.out.println(list);

    }

    public static void function_4() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));
    }

    public static void function_3() {
        Set<Person> s = new HashSet<Person>();
        s.add(new Person("a", 1));
        s.add(new Person("b", 2));
        s.add(new Person("c", 3));

//        for (Person ss : s){
//            ss.setAge(99);
//        }

        System.out.println(s);

//        for(Person ss : s){
//            System.out.println(s);
//        }

    }

    public static void function_2() {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("2");
        set.add("4");
        set.add("6");
        set.add("dd");

        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

    public static void function_1() {
        List<String> L = new ArrayList<String>();
        L.add("a");
        L.add("b");
        L.add("c");
        System.out.println(L);
        ;
        L.add(0, "a0");
        System.out.println(L);
        L.remove(2);
        System.out.println(L);
        L.remove("c");
        System.out.println(L);
        L.set(1, "e");
        System.out.println(L);

        Iterator<String> it = L.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());
        }

    }
}
