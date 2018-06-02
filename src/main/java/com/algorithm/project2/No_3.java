package com.algorithm.project2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class No_3 {
    private static int arrSize;

    public static void main(String[] args) {
        //输入选择
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数组规模大小（20000~100000）：");
        arrSize=sc.nextInt();
        sc.close();

        //生成随机数组
        int[] arr = arrRandom();
        System.out.println("测试的随机数组为：");
        System.out.println(Arrays.toString(arr));

        //排序并计时
        long timeStart=System.currentTimeMillis();
        hoareQsort(arr, 0, arr.length - 1);
        long timeEnd=System.currentTimeMillis();

        //输出结果
        System.out.println("======================================================");
        System.out.println("排序结果：");
        System.out.println(Arrays.toString(arr));
        System.out.println("耗时："+(timeEnd-timeStart)+"毫秒");
    }

    //在循环里弄尾递归
    public static void hoareQsort(int[] arr, int left, int right) {
        int pivot;
        //尾递归版本
        while (left < right) {
            pivot = hoarePartition(arr, left, right);
            hoareQsort(arr, left, pivot);
            left = pivot + 1;
        }

        //第二题还没尾递归的版本
        //        if (left >= right)
        //            return;
        //        int pivot = hoarePartition(arr, left, right);
        //
        //        hoareQsort(arr, left, pivot);
        //        //hoareQsort(arr, pivot + 1, right);
        //        left=pivot+1;
    }

    //划分 返回轴点
    public static int hoarePartition(int[] arr, int left, int right) {
        int base = arr[left];
        int i = left;
        int j = right;
        int temp;

        while (true) {
            for (; i < right && arr[i] < base; i++) ;
            for (; j > left && arr[j] >= base; j--) ;

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                return j;
            }
        }
    }

    //获取随机数组
    public static int[] arrRandom() {
        int[] arr = new int[arrSize];
        Random random = new Random();
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }
        return arr;
    }
}
