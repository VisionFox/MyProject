package com.algorithm.project1;

import java.util.Arrays;
import java.util.Scanner;

public class No_1target {
    public static void main(String[] args) {
        //初始化操作
        int target;
        boolean result = false;
        int[] arr = {9, 4, 2, 3, 0, 1, 8, 7, 6, 5, 100};
        System.out.println("测试数组为：" + Arrays.toString(arr));

        //进行归并排序
        split(arr, 0, arr.length - 1);
        System.out.println("归并排序结果为：" + Arrays.toString(arr));

        //获取目标值
        System.out.println("请输出目标值：");
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        sc.close();


        //确定temp值，准备二分查找
        for (int i = 0; i < arr.length; ++i) {
            int temp = target - arr[i];
            result = binarySearch(i + 1, arr.length - 1, arr, temp);
            if (result) {
                break;
            }
        }

        //结果输出
        if (result == true) {
            System.out.println("数组中 存在 两个数，相加等于: " + target);
        } else {
            System.out.println("数组中 不存在 两个数，相加等于: " + target);
        }

    }

    //归并法排序
    //1.先对半切割 递归
    public static void split(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            split(arr, left, mid);
            split(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //2.归并的同时进行排序
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int tempIndex = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tempArr[tempIndex++] = arr[j++];
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


    //二分查找
    public static boolean binarySearch(int low, int hight, int[] arr, int temp) {

        while (low <= hight) {
            int middle = (hight + low) / 2;
            if (temp == arr[middle]) {
                return true;
            }
            if (arr[middle] > temp) {
                hight = middle - 1;
            }
            if (arr[middle] < temp) {
                low = middle + 1;
            }
        }
        return false;
    }
}
