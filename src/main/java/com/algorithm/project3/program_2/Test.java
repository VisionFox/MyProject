package com.algorithm.project3.program_2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int[] a={1,7,6,5,5,1,3,2,1,2};
        int[] a={7,6,5,4,3,3,1,2,1};
        iqsort0(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    //主元为第一个元素
    public static void iqsort0(int[] a, int left, int right) {
        int i, j;
        if (left >= right) {
            return;
        }

        for (i = left + 1, j = left; i <= right; i++) {
            if (a[i] < a[left]) {
                ++j;
                swap(j, i, a);
            }
        }
        swap(left, j, a);

        iqsort0(a,left,j-1 );
        iqsort0(a,j+1,right);
    }

    public static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
