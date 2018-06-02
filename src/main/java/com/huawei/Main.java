package com.huawei;

//import java.util.Calendar;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= -170) {
            System.out.println(-1000);
            return;
        }

        if (num >= 550) {
            System.out.println(7500);
            return;
        }

        if (num==0){
            System.out.println(700);
            return;
        }

        if (num == 40){
            System.out.println(940);
            return;
        }

        if (num == 300){
            System.out.println(2500);
            return;
        }



        if (num > -170 && num <= 0) {
            int res = -1000 + (num - (-170)) * ((700 - (-1000)) / (700 - 170));
            System.out.println(res);
            return;
        }

        if (num > 0 && num <= 40) {
            int res = 700 + (num - 0) * ((940 - 700) / 40);
            System.out.println(res);
            return;
        }

        if (num > 40 && num <= 300) {
            int res = 940 + (num - 40) * ((2500 - 940) / 260);
            System.out.println(res);
            return;
        }

        if (num > 300 && num <= 550) {
            int res = 2500 + (num - 300) * ((7500 - 2500) / 250);
            System.out.println(res);
            return;
        }

    }
}
