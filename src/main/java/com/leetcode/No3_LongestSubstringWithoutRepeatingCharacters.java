package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        function_2("ababccafkss");
    }

    public static void function_2(String s) {
        char[] ch = new char[128];
        for (int i = 0; i < s.length(); ++i) {

        }
    }

    public static void function_1(String s) {
        int res = 0, len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int index = 0, flag = 0; index < len; ++index) {
            //flag是（被找出重复过最近的那两个字符的第一个所在位置）和（containkey的位置）做比较，哪个最近标志哪个
            //下标加一的原因是防止零的干扰比如3-0，实际只有两个长度
            if (map.containsKey(s.charAt(index))) {
                flag = Math.max(map.get(s.charAt(index)), flag);
            }
            map.put(s.charAt(index), index + 1);
            res = Math.max(res, index + 1 - flag);
        }
        System.out.println(res);
    }
}
