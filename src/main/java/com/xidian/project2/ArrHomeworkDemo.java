package com.xidian.project2;

import java.util.ArrayList;

public class ArrHomeworkDemo {
    public static void main(String[] args) {
        int[][] a={{-1,-3,-9},{1,4,6,2,5,4},{4,5,2,9},{7,8,1,1,1,1,1,1,1,1,1},{8,9,7},{-2,-3,-5,-7,-3,-2}};
        showArr(a);//显示数组内容的
        System.out.println();
        ArrayList<Integer> maxRowNo=new ArrayList<Integer>();//可能有几行的和都是最大的且一样的，ArrayLsit存行号克自动扩容
        maxRowNo.add(0);//先默认有最大和的行号为零
        int maxSum=0;//初始化为零只是为了编译通过，通过和flag结合后面先存第0行的内容
        int flag=0;

        for (int i=0;i<a.length;++i){
            int sum=0;
            //下面循环算出行中的元素和
            for (int j=0;j<a[i].length;++j){
                sum+=a[i][j];
            }
            System.out.println("第"+i+"行的求和结果为："+sum);

            if (flag==0){
                maxSum=sum;
                ++flag;
            }
            //确认哪一行的和最大并且记录行号
            if (maxSum<sum){
                maxRowNo.clear();
                maxRowNo.add(i);
                maxSum=sum;
            } else if(maxSum==sum){
                maxRowNo.add(i);
            }
        }
        System.out.println();
        showRowResult(maxRowNo);//写成符合结果的行号
    }

    public static void showRowResult(ArrayList<Integer> arr){
        System.out.print("和为最大的行号为：");
        for (Integer i : arr){
            System.out.print(i+" ");
        }
    }

    public static void showArr(int[][] arr){
        for (int i=0;i<arr.length;++i){
            System.out.print("第"+i+"行的数据为：");
            for (int j : arr[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}