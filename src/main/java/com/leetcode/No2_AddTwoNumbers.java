package com.leetcode;

import java.util.Scanner;

public class No2_AddTwoNumbers {
    public static void main(String[] args) {
        No2_ListNode list1 = list(2, 4, 3);
        No2_ListNode list2 = list(5, 6, 4);
        show(list1);
        show(list2);
        function(list1, list2);
        No2_ListNode result = function(list1, list2);
        show(result);

    }

    public static No2_ListNode function(No2_ListNode list1, No2_ListNode list2) {
        No2_ListNode resulthead = new No2_ListNode(0);
        No2_ListNode resultnext = resulthead;
        int carr = 0, sum = 0;
        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.val : 0;
            int y = (list2 != null) ? list2.val : 0;
            sum = x + y + carr;
            carr = sum / 10;
            resultnext.next = new No2_ListNode(sum % 10);
            resultnext = resultnext.next;
            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }
        if (carr > 0) {
            resultnext.next = new No2_ListNode(carr);
        }
        return resulthead.next;
    }

    public static No2_ListNode list(int... a) {
        No2_ListNode listh = new No2_ListNode(a[0]);
        No2_ListNode listn = listh;
        for (int i = 1; i < a.length; ++i) {
            listn.next = new No2_ListNode(a[i]);
            listn = listn.next;
        }
        listn = null;
        return listh;
    }

    public static void show(No2_ListNode list) {
        while (list != null) {
            System.out.print(list.val);
            System.out.print("->");
            list = list.next;
        }
        System.out.println("null");
    }
}
