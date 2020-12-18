package com.coderjiang.DailyPractice.Monthly_2020_12;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/18 9:11
 * @description: 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 */
public class LeetCode_Daily_12_18 {
    public static void main(String[] args) {

    }

    static class Solution {
        /*
         * @name: 计数法
         * */
        public char findTheDifference_count(String s, String t) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                if (--count[ch - 'a'] < 0) {
                    return ch;
                }
            }
            return ' ';
        }

        /*
         * @name: 异或法
         * @description: 由于每个字母一定会出现双数次，唯独插入的字母是只出现一次的，那么异或两遍的结果是0
         * */
        public char findTheDifference(String s, String t) {
            int result = 0;
            for (char ch : (s + t).toCharArray()) {
                result ^= ch;
            }
            return (char) result;
        }
    }
}
