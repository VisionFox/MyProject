package com.huawei.huawei2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        while (sc.hasNext()) {
            String words = sc.nextLine();
            if (words.charAt(0) == ';') {
                continue;
            }
            if (words.indexOf(';') > 0) {
                words = words.substring(0, words.indexOf(';'));
            }
            arr.add(words);
        }

        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < arr.size(); ++i) {
            if ((arr.get(i).charAt(0)) == '[') {
                String flag = arr.get(i);
                for (int j = i + 1; j < arr.size() && arr.get(j).charAt(0) != '['; ++j) {
                    String key = arr.get(j).substring(0, arr.get(j).indexOf('='));
                    String value = arr.get(j).substring(arr.get(j).indexOf('=') + 1, arr.get(j).length());
                    res.add("{" + flag + "}" + "{" + key + "}" + "{" + value + "}");
                }
            }
        }

        String[] res2 = (String[]) res.toArray();

        Arrays.sort(res2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < res2.length; ++i) {
            System.out.println(res2[i]);
        }
    }
}
