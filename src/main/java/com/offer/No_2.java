package com.offer;

import java.util.Arrays;

public class No_2 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("123 4")));
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }

        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                flag++;
            }
        }

        char[] newChar = new char[str.length() + 2 * flag];
        for (int index_2 = newChar.length - 1, index_1 = str.length() - 1; index_1 >= 0; index_1--) {
            if (str.charAt(index_1) != ' ') {
                newChar[index_2] = str.charAt(index_1);
                index_2--;
            } else {
                newChar[index_2 - 2] = '%';
                newChar[index_2 - 1] = '2';
                newChar[index_2] = '0';
                index_2 -= 3;
            }
        }

        return new String(newChar);
    }
}
