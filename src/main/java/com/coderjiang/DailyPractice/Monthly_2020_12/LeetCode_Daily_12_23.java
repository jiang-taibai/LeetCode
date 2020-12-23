package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/23 9:46
 * @description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class LeetCode_Daily_12_23 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int firstUniqChar(String s) {
            int[] counts = new int[26];
            for (Character c : s.toCharArray()) {
                counts[c - 'a']++;
            }

            Set<Character> candidate = new HashSet<Character>();
            for (int i = 0; i < 26; ++i) {
                if (counts[i] == 1) candidate.add((char) ('a' + i));
            }

            for (int i = 0; i < s.length(); ++i) {
                if (candidate.contains(s.charAt(i))) {
                    return i;
                }
            }
            return -1;
        }
    }
}
