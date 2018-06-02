package com.algorithm.project2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class No_2 {
    private static int arrSize;
    private static int swapTemp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入随机数组的规模大小（20000~100000）：");
        arrSize = sc.nextInt();
        sc.close();

        int[] arr = arrRandom();
        System.out.println("生成的随机数组为：");
        System.out.println(Arrays.toString(arr));

        long timeStart = System.currentTimeMillis();
        hoareQsort(arr, 0, arr.length - 1);
        long timeEnd = System.currentTimeMillis();

        System.out.println("===================================================================");
        System.out.println("排好序的数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("耗时：" + (timeEnd - timeStart) + "毫秒");
    }


    //hoare快排
    public static void hoareQsort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivot = hoarePartition(arr, left, right);

        hoareQsort(arr, left, pivot);
        hoareQsort(arr, pivot + 1, right);
    }

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

    //书上的原版快排
    public static void originQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int q = originPartition(arr, left, right);
            originQuickSort(arr, left, q - 1);
            originQuickSort(arr, q + 1, right);
        }
    }

    public static int originPartition(int[] arr, int left, int right) {
        int base = arr[right];
        int i = left - 1;
        for (int j = left; j <= right - 1;j++ ){
            if (arr[j]<=base){
                i++;
                swapTemp=arr[i];
                arr[i]=arr[j];
                arr[j]=swapTemp;
            }
        }

        swapTemp=arr[i+1];
        arr[i+1]=arr[right];
        arr[right]=swapTemp;

        return i+1;
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
