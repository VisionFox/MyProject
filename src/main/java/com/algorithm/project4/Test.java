package com.algorithm.project4;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        String input_1Path = "C:\\Users\\Administrator\\Desktop\\算法\\4\\EditDistanceData\\input1.txt";
        String input_2Path = "C:\\Users\\Administrator\\Desktop\\算法\\4\\EditDistanceData\\input2.txt";
        String input_3Path = "C:\\Users\\Administrator\\Desktop\\算法\\4\\EditDistanceData\\input3.txt";
        //想运行哪个文件自己改下面一行和上面几行的路径
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input_3Path));

        //在linux里换行符只包括\n，而windows中换行包含两部分\r\n。
        // java语言在使用IDE：Intellij idea的UTF-8编码时，读一行readline是以\r或者\n结束，所以下面才那么多readline

        //读取第一行
        bufferedReader.readLine();//\r
        bufferedReader.readLine();//\n
        //读取第二行
        String source = bufferedReader.readLine();
        bufferedReader.readLine();//\n
        //读取第三行
        bufferedReader.readLine();//\r
        bufferedReader.readLine();//\n
        //读取第四行
        String target = bufferedReader.readLine();

        System.out.println(source);
        System.out.println(target);

        int[][] a = editDistance(source, target);

        for (int i = 0; i <= target.length(); i++) {
            for (int j = 0; j <= source.length(); j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("所求编辑距离为："+a[target.length()][source.length()]);
    }

    //编辑距离计算
    public static int[][] editDistance(String source, String target) {
        int n = target.length();
        int m = source.length();
        int[][] D = new int[n + 1][m + 1];
        //4
        int replaceCost = 4;
        //2
        int deleteCost = 2;
        //3
        int insertCost = 3;

        //初始化
        D[0][0] = 0;
        for (int i = 1; i <= target.length(); i++) {
            D[i][0] = i * insertCost;
        }
        for (int j = 1; j <= source.length(); j++) {
            D[0][j] = j * deleteCost;
        }
        int a, b, c;
        //动态规划填满表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a = D[i - 1][j] + insertCost;
                b = D[i - 1][j - 1] + (target.charAt(i - 1) == source.charAt(j - 1) ? 0 : replaceCost);
                c = D[i][j - 1] + deleteCost;
                D[i][j] = min(a, b, c);
            }
        }
        return D;
    }

    //返回三位数的最小值
    public static int min(int a, int b, int c) {
        int min = a > b ? b : a;
        min = min > c ? c : min;

        return min;
    }
}
