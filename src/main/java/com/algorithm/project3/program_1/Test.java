package com.algorithm.project3.program_1;

public class Test {
    public static void main(String[] args) {

    }

    public void iisort(int[] a, int n) {
        int i, j;
        for (i = 1; i < n; i++) {
            for (j = i; j > 0 && a[j - 1] > a[j]; j--) {
                iswap(j, j - 1, a);
            }
        }
    }


    public void iswap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void isort(char[] a,int n){
        char pi,pj;

    }

    public int cmp(char pi,char pj){
        return 0;
    }

    public void swap(char[] a, int i, int j, int n) {
        char temp;
        do {
            temp = a[i];
            a[i++] = a[j];
            a[j++] = temp;
        } while (--n > 0);
    }
}
