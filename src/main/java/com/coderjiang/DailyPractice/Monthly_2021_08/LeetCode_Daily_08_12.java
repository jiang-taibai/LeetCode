package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-12 15:50:42</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_12 {

    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            String s2 = "232";
            if (s == s2) {

            }
            for (int i = n; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    if (i == j) dp[i][j] = 1;
                    else {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else {
                            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

}
