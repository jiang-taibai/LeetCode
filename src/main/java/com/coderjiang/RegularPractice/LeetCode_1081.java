package com.coderjiang.RegularPractice;

import java.util.*;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 21:21
 * @description: 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * @get: 可以直接由set转换为ArrayList：ArrayList<Character> arr = new ArrayList<Character>(set);
 */
public class LeetCode_1081 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String smallestSubsequence(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (Character c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }

            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                Character ch = s.charAt(i);
                if (!stack.contains(ch)) {
                    while (!stack.isEmpty() && map.get(stack.peek()) > 0 && stack.peek() > ch) {
                        stack.pop();
                    }
                    stack.add(ch);
                }
                map.put(ch, map.get(ch) - 1);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
}
