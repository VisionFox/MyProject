package com.xidian.project1;

public class ArrMinDemo {
    public static void main(String[] args) {
        int[] a={1,5,3,7,9,0,8,3,7,4,9,0,8,9};
        showArr(a);//一个打出a数组内容的子函数只是为了方便查看数组内容
        int resultIndex=-1;//记录结果下标位置
        System.out.println("所找最大值的最小下标为："+function(a));
    }
    //实现题目功能
    public static int function(int[] a){
        int minIndex=0;
        int maxNum=a[0];
        for (int i=0;i<a.length;++i){
            if (a[i]>maxNum){
                minIndex=i;
                maxNum=a[i];
            }
        }
        return minIndex;
    }

    //显示传入数组的内容
    public static void showArr(int[] a){
        System.out.print("数组数据为：");
        for (int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
