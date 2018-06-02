package com.test.pkg2;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {

//        StringBuilder

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(m);
        System.out.println(n);

    }

    int[] flagArr = new int[256];
    int index = 1; //标记第几次出现

    public void Insert(char ch) {
        if (flagArr[ch] == 0) {
            flagArr[ch] = index;
            ++index;
        } else {
            flagArr[ch] = -1;//标记重复出现过
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char res = '#';
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < 256; ++i) {
            if (flagArr[i] != -1 && flagArr[i] != 0 && flagArr[i] < temp) {
                temp = flagArr[i];
                res = (char) i;
            }
        }
        return res;
    }

    public boolean isNumeric(char[] str) {
        String myStr = str.toString();
        return myStr.matches("[+-]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?");
    }


    public String ReverseSentence(String str) {
        if (str.length() == 0 || str == null) {
            return str;
        }
        char[] c = str.toCharArray();
        int first = 0, last = 0;
        while (last <= str.length()) {
            if (c[last] == ' ' || last == str.length()) {
                reverse(c, first, last - 1);
                first = last + 1;
            }
            ++last;
        }
        reverse(c, 0, str.length() - 1);
        return new String(c);
    }

    public String LeftRotateString(String str, int n) {
        if (n == 0 || str.length() == 0) {
            return str;
        }
        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, c.length - 1);
        reverse(c, 0, c.length - 1);
        return c.toString();
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            ++i;
            --j;
        }
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        if (index < 7) {
            return index;
        }

        //还没乘过2,3,5的下标
        int t2 = 0, t3 = 0, t5 = 0;
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;

        for (int i = 1; i < index; ++i) {
            uglyNums[i] = Math.min(uglyNums[t2] * 2, Math.min(uglyNums[t3] * 3, uglyNums[t5] * 5));
            if (uglyNums[i] == uglyNums[t2] * 2) {
                ++t2;
            }
            if (uglyNums[i] == uglyNums[t3] * 3) {
                ++t3;
            }
            if (uglyNums[i] == uglyNums[t5] * 5) {
                ++t5;
            }
        }
        return uglyNums[index - 1];
    }


    public static String oop(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }

        int len = numbers.length;
        String[] strs = new String[len];

        for (int i = 0; i < len; ++i) {
            strs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        //连接字符串最好用这个，用加号容易产生多余的对象
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
