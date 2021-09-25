package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-25 02:42:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_25 {

    class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return n + m - 2 * dp[n][m];
        }
    }

}
