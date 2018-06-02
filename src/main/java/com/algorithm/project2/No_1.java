package com.algorithm.project2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class No_1 {
    private static int baseCase;//标记主元生成方式
    private static int arrCase;//标记数组生成方式
    private static int arrSize;//标记数组大小
    private static int base;//存储主元
    private static int baseIndex;//标记主元下标
    private static int pivot;//标记数组划分的轴点
    private static int swapTemp;//交换变量的缓冲
    private static Random random = new Random();//用于获取随机值的java Randow实例化对象
    //选取3,5位随机数中值时，经常用到的一些容器
    private static int[] medianIndexBuff3 = new int[3];
    private static int[] arrBuff3 = new int[3];
    private static int[] medianIndexBuff5 = new int[5];
    private static int[] arrBuff5 = new int[5];

    //主函数 初始化题目条件
    public static void main(String[] args) {
        //用户进行功能选择
        Scanner sc = new Scanner(System.in);
        System.out.println("选择主元的生成方式：1.第一个元素  2.随机  3.三个随机数的中位数  4.五个随机数的中位数");
        baseCase = sc.nextInt();
        System.out.println("选择数组数据的产生方式: 1.有序  2.逆序  3.随机");
        arrCase = sc.nextInt();
        System.out.println("请选择数组规模（20000~100000）：");
        arrSize = sc.nextInt();
        sc.close();

        //根据选择生成测试数组
        int[] arr = new int[arrSize];
        switch (arrCase) {
            case 1:
                arr = arrSorted();
                break;
            case 2:
                arr = arrReverse();
                break;
            case 3:
                arr = arrRandom();
                break;
        }
        System.out.println("生成的数组为：");
        System.out.println(Arrays.toString(arr));

        //排序并计时
        long timeStart = System.currentTimeMillis();//计时
        quickSort(arr, 0, arr.length - 1);
        long timeEnd = System.currentTimeMillis();//计时

        //输出结果
        System.out.println("===================================================================");
        System.out.println("数组排序完成：");
        System.out.println(Arrays.toString(arr));
        System.out.println("耗时" + (timeEnd - timeStart) + "毫秒");
        System.out.println(arr.length);
    }


    //教科书快排优化版
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        //根据划分后子数组的大小选择排序方式
        if ((right - left + 1) <= 20) {
            insertSort(arr, left, right);
        } else {
            pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        //根据用户选择的参数baseCase，获取主元（base）及主元下标（baseIndex）的生成方式
        //1:1st element  2:random  3:median of random three  4:median of random five
        if (baseCase == 1) {
            baseIndex = left;
        } else if (baseCase == 2) {
            baseIndex = random.nextInt(right) % (right - left + 1) + left;
        } else if (baseCase == 3) {
            for (int i = 0; i < 3; i++) {
                medianIndexBuff3[i] = random.nextInt(right) % (right - left + 1) + left;
                arrBuff3[i] = arr[medianIndexBuff3[i]];
            }
            Arrays.sort(arrBuff3);
            for (int i = 0; i < 3; i++) {
                if (arr[medianIndexBuff3[i]] == arrBuff3[1]) {
                    baseIndex = medianIndexBuff3[i];
                    break;
                }
            }
        } else if (baseCase == 4) {
            for (int i = 0; i < 5; i++) {
                medianIndexBuff5[i] = random.nextInt(right) % (right - left + 1) + left;
                arrBuff5[i] = arr[medianIndexBuff5[i]];
            }
            Arrays.sort(arrBuff5);
            for (int i = 0; i < 5; i++) {
                if (arr[medianIndexBuff5[i]] == arrBuff5[2]) {
                    baseIndex = medianIndexBuff5[i];
                    break;
                }
            }
        }

        //下面进行划分
        base = arr[baseIndex];
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (arr[j] <= base && j != baseIndex) {
                ++i;
                if (i == baseIndex) {
                    ++i;
                }
                swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        if (baseIndex <= i) {
            i--;
        }

        swapTemp = arr[i + 1];
        arr[i + 1] = base;
        arr[baseIndex] = swapTemp;

        //返回轴点
        return i + 1;
    }

    //插入排序
    public static void insertSort(int[] arr, int left, int right) {
        if (left == right)
            return;

        int temp;
        int j;

        for (int i = left + 1; i <= right; i++) {
            j = i - 1;
            temp = arr[i];

            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];//往后挪
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    //获取有序数组
    public static int[] arrSorted() {
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; ++i) {
            arr[i] = i / 100 + 1;
        }
        return arr;
    }

    //获取逆序数组
    public static int[] arrReverse() {
        int[] arr = new int[arrSize];
        int index = 0;
        for (int i = arrSize - 1; i >= 0; i--) {
            arr[index++] = i / 100 + 1;
        }
        return arr;
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
