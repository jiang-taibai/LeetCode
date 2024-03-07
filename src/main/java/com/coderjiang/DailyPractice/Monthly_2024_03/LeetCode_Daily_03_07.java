package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/7</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_07 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] res = new int[n];
            long remainder = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < n; i++) {
                char c = chars[i];
                remainder = (remainder * 10 + (c - '0')) % m;
                if (remainder == 0) res[i] = 1;
            }
            return res;
        }
    }

}
