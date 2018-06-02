package com.algorithm.project5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    private static int M;
    private static int N;

    private static int P;
    private static int E;

    private static ArrayList<String> str = new ArrayList<String>();


    public static void main(String[] args) {
        init();

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入工作人员数量M：");
        M = sc.nextInt();
        System.out.print("请输入开门所需人数N：");
        N = sc.nextInt();
        sc.close();

        P = C(M, M - N + 1);
        E = C(M - 1, N - 1);

        System.out.println("电子锁最少总特征数：" + P);
        System.out.println("每人磁卡最少特征数：" + E);


        ArrayList<Integer> resultSon = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        make(1, 0, resultSon, result);

        HashMap<Integer, ArrayList<String>> card = new HashMap<Integer, ArrayList<String>>();

        deal(result, card);
    }


    public static void init() {
        for (int i = 0; i < 26; i++) {
            str.add(String.valueOf((char) ('a' + i)));
        }
        for (int i = 0; i < 9; i++) {
            str.add(String.valueOf((char) ('a' + i)) + "a");
        }
    }

    public static int C(int n, int m) {
        int a1 = 1, a2 = 1, a3 = 1;
        for (int i = 1; i <= n; i++) {
            a1 *= i;
        }
        for (int i = 1; i <= m; i++) {
            a2 *= i;
        }
        for (int i = 1; i <= (n - m); i++) {
            a3 *= i;
        }
        return a1 / (a2 * a3);
    }

    public static void make(int a, int b, ArrayList<Integer> resultSon, ArrayList<ArrayList<Integer>> result) {
        if (a > M - N + 1) {
            return;
        }
        for (int i = b + 1; i <= M; i++) {
            resultSon.add(i);
            if (a == M - N + 1) {
                result.add((ArrayList<Integer>) resultSon.clone());
            }
            make(a + 1, i, resultSon, result);
            resultSon.remove(resultSon.size() - 1);
        }


    }

    public static void deal(ArrayList<ArrayList<Integer>> result, HashMap<Integer, ArrayList<String>> card) {
        for (int i = 1; i <= M; i++) {
            card.put(i, new ArrayList<String>());
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                card.get(result.get(i).get(j)).add(str.get(i));
            }
        }

        for (int i = 1; i <= card.size(); i++) {
            System.out.println("#" + i + ": " + card.get(i));
        }
    }


}
