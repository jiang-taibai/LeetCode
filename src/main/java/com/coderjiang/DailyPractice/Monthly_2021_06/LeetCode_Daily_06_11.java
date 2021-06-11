package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_11 {

    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j * j <= i; j++) {
                    min = Math.min(min, dp[i - j * j]);
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }
    }

}