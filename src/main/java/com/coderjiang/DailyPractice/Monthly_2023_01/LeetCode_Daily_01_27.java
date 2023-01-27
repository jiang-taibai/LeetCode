package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-27 14:10:35</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_27 {

    public static void main(String[] args) {
        int[][] tests = {
                {3, 27},
                {5, 73},
        };
        String[] expects = {
                "aay",
                "aaszz",
        };
        Solution solution = new Solution();
        for (int i = 0; i < tests.length; ++i) {
            int n = tests[i][0];
            int k = tests[i][1];
            System.out.printf("[n=%d, k=%d], Output: %s, Expect: %s\n", n, k, solution.getSmallestString(n, k), expects[i]);
        }
    }

    static class Solution {
        public String getSmallestString(int n, int k) {
            for (int i = n; i >= 0; --i) {
                String res = getPostString(i, n - i, k - i);
                if (res != null) return getString(i, 'a') + res;
            }
            return null;
        }

        private String getString(int count, char ch) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; ++i) {
                sb.append(ch);
            }
            return sb.toString();
        }

        private String getPostString(int pre, int post, int k) {
            // 如果后缀全为z都不够k，则表示该结构不匹配
            if (post * 26 < k) return null;
            // 否则应该是刚刚好，取post-1位不够k，取post位比k多
            StringBuilder sb = new StringBuilder();
            if (k % 26 != 0) sb.append((char) ((k % 26 - 1) + 'a'));
            for (int i = 0; i < k / 26; ++i) {
                sb.append('z');
            }
            return sb.toString();
        }
    }

}
