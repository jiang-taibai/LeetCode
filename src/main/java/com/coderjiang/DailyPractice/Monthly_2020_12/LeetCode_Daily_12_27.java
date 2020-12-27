package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘江
 * @modifyTime 2020/12/27 14:30
 * @description TODO
 */
public class LeetCode_Daily_12_27 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            return parseConstruction(s).equals(parseConstruction(t));
        }

        private String parseConstruction(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(Character c : s.toCharArray()) {
                if(!map.containsKey(c)) {
                    map.put(c, index++);
                }
                sb.append(String.valueOf(map.get(c)));
            }
            return sb.toString();
        }
    }
}
