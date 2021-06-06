package com.coderjiang.DailyPractice.Monthly_2021_06;

/**
 * <p>创建时间：2021/6/6 22:34</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_06_06 {

    class Solution {

        private int countChar(String s, char ch) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) cnt++;
            }
            return cnt;
        }

        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp = new int[len + 1][m + 1][n + 1];
            for (int i = 1; i <= len; ++i) {
                int count0 = countChar(strs[i - 1], '0');
                int count1 = countChar(strs[i - 1], '1');
                for (int j = 0; j <= m; ++j) {
                    for (int k = 0; k <= n; ++k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (count0 <= j && count1 <= k) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count0][k - count1] + 1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }
    }

}
