package com.offer;

import java.util.Arrays;

public class No_6fanwaipian {
    public static void main(String[] args) {
        int[] a = new int[5];

    }

    /**
     * /o(n)时间复杂度排序一个数组
     * arr里面的数大小范围不是很大时可以用
     * 并且没有负数时可用
     *
     * @param arr
     */
    public void sortOn(int[] arr) {
        int len = arr.length;

        if (arr == null || len <= 0) {
            return;
        }

        int[] timesNum = new int[len];

        for (int i = 0; i < len; ++i) {
            ++timesNum[arr[i]];
        }

        int index = 0;
        //假定这是arr里最大的数
        int maxNum = 99;
        for (int i = 0; i <= maxNum; ++i) {
            for (int j = 0; j < timesNum[i]; ++j) {
                arr[index] = i;
                ++index;
            }
        }


    }
}
