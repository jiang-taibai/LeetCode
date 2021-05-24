package com.coderjiang.DailyPractice.Monthly_2021_05;

/**
 * <p>创建时间：2021/5/24 15:50</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_24 {

    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; ++k) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
            return dp[0][n - 1];
        }
    }

}
