package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.*;

/**
 * <p>创建时间：2021/5/15 19:52</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_15 {

    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new TreeMap<Character, Integer>() {{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
                put('1', 4);
                put('2', 9);
                put('3', 40);
                put('4', 90);
                put('5', 400);
                put('6', 900);
            }};
            List<String> arrayList = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");
            s = s.replaceAll("IV", "1")
                    .replaceAll("IX", "2")
                    .replaceAll("XL", "3")
                    .replaceAll("XC", "4")
                    .replaceAll("CD", "5")
                    .replaceAll("CM", "6");
            int res = 0;
            for (Character ch : s.toCharArray()) {
                res += map.get(ch);
            }
            return res;
        }
    }

}
