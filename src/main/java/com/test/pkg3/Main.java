package com.test.pkg3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        TreeSet<Integer> set=new TreeSet();
//        set.add(3);
//        set.add(2);
//        set.add(1);
//
//        System.out.println(set.pollLast());

        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        queue.add('a');
        queue.add('b');
        queue.add('m');
        queue.add('e');
        queue.add('c');
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

        String p="sasd";
//        p.matches()

//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        char[] cArr = str.toCharArray();
//        int[] tempArr = new int['9' + 1];
//
//        for (char c : cArr) {
//            ++tempArr[c];
//        }
//
//        StringBuilder res = new StringBuilder();
//
//        for (int i = str.length() - 1; i >= 0; --i) {
//            if (tempArr[cArr[i]] == 1) {
//                res.append(cArr[i]);
//            }
//        }
//
//        ArrayList<Integer> list=new ArrayList<>();
//        list.clone();
//
//        System.out.println(res);
    }
}
