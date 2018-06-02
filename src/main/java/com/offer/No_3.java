package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class No_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //后进先出 仿栈

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return result;
        }
        while (listNode != null) {
            result.add(0, listNode.val);
            if (listNode.next == null) {
                break;
            } else {
                listNode = listNode.next;
            }
        }
        return result;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}