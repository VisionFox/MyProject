package com.xidian.project7;

import java.util.Iterator;
import java.util.LinkedList;

public class Test4 {
    public static void main(String[] args) {
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        show(s);
    }

    public static void show(String s) {
        System.out.println("输入的字符串为：" + s);
        System.out.println("处理出栈数据过程如下：");

        LinkedList<Character> linkedList = new LinkedList<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+') {
                linkedList.addFirst(s.charAt(i + 1));
            } else if (s.charAt(i) == '-') {
                System.out.print(linkedList.removeFirst() + " ");
            }
        }

        System.out.println();
        System.out.print("最终linkedlist里的内容为：");
        if (linkedList.isEmpty()) {
            System.out.println("空");
        } else {
            Iterator<Character> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }
}
