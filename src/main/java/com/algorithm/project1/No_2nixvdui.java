package com.algorithm.project1;

import java.util.Arrays;

public class No_2nixvdui {

    private static int inverParisCount = 0;//逆序对的计数变量

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3, -2, 5};
        System.out.println("测试数组为：" + Arrays.toString(arr));
        split(arr, 0, arr.length - 1);
        System.out.println("归并排序结果为：" + Arrays.toString(arr));
        System.out.println("逆序对有：" + inverParisCount + "对");
    }

    //对半切割 递归
    public static void split(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            split(arr, left, mid);
            split(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //归并排序
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int tempIndex = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tempArr[tempIndex++] = arr[j++];
                inverParisCount += mid - i + 1;//计数
            } else {
                tempArr[tempIndex++] = arr[i++];
            }
        }

        while (i > mid && j <= right) {
            tempArr[tempIndex++] = arr[j++];
        }

        while (j > right && i <= mid) {
            tempArr[tempIndex++] = arr[i++];
        }

        for (int k = 0; k < tempArr.length; ++k) {
            arr[left + k] = tempArr[k];
        }
    }
}
