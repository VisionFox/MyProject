package com.xidian.project7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test8 {
    static String[] s = new String[4];

    static {
        s[0] = "I have a dream that one day this nation will rise up, "
                + "live up to the true meaning of its creed: "
                + "\"We hold these truths to be self-evident; "
                + "that all men are created equal.”";

        s[1] = "I have a dream that one day on the red hills of Georgia "
                + "the sons of former slaves and the sons of former slave-owners "
                + "will be able to sit down together at the table of brotherhood.";

        s[2] = "I have a dream that one day even the state of Mississippi, "
                + "a state sweltering with the heat of injustice, "
                + "sweltering with the heat of oppression, "
                + "will be transformed into an oasis of freedom and justice";

        s[3] = "I have a dream that my four children will one day live in a nation "
                + "where they will not be judged by the color if their skin "
                + "but by the content of their character.";
    }

    public static void main(String[] args) {
        Map<String, Integer> statistics = new HashMap<String, Integer>();

        //切分字符串
        ArrayList<String> splitedWord = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            String[] temp = s[i].split("[^-a-zA-Z]+");
            //此正则表达式的意义为：不含字符“-”、“a”到“z”、“A”到“Z”，长度>=1的连续字符。以此作为切割

            for (int j = 0; j < temp.length; j++) {
                splitedWord.add(temp[j]);
            }
        }
        System.out.println("切割结果为：" + splitedWord);

        //进行统计
        for (String word : splitedWord) {
            if (statistics.get(word) != null) {
                statistics.put(word, statistics.get(word) + 1);
            } else {
                statistics.put(word, 1);
            }
        }
        System.out.println("词频统计结果为：" + statistics);

    }
}
