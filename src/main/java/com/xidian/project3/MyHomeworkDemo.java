package com.xidian.project3;

import java.util.Arrays;

public class MyHomeworkDemo {
    public static void main(String[] args) {
        int val=0;
        String[] str1,str2;
        int c=0;
        /*
        1.将i循环在为两位数范围内
        2.找出min和max，其中i和【min，max】这个范围内的数相乘得到四位数的乘积结果，并且min和max均是两位数
        3.分别将i和j及乘积var转换为字符串，其中（j和i连接）并一个数字一个数字切割为字符串数组
        4.将切割好的数组排好序，比较内容，若一样则为吸血鬼数
         */
        for (int i=10;i<100;++i){
            int min=Math.max(1000/i,i+1);
            int max=Math.min(10000/i,99);
            for (int j=min;j<=max;++j){
                ++c;
                val=j*i;
                //将两数的乘积用String类的valuefo方法转换为字符串，再用split方法切割为String数组
                str1=String.valueOf(val).split("");

               //用String类的valuefo方法将i和j转换为字符串再连接好，再用split方法切割为String数组
                str2=(String.valueOf(i)+String.valueOf(j)).split("");

                //用Arrays的sort方法把str1和str2在内部排好序
                Arrays.sort(str1);
                Arrays.sort(str2);

                //用equals比较Str1和str2的内容，若内容相等则为吸血鬼数
                if (Arrays.equals(str1,str2)){
                    System.out.println(val+"="+i+"*"+j);
                }
            }
        }
        System.out.println(c+"次");
    }
}
