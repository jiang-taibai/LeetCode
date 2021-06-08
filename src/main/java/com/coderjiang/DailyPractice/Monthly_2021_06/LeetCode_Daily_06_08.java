package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.*;

public class LeetCode_Daily_06_08 {

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length;
            int sum = Arrays.stream(stones).sum();
            int t = sum / 2;
            int[][] dp = new int[n + 1][t + 1];
            for (int i = 1; i <= n; ++i) {
                int x = stones[i - 1];
                for (int j = 0; j <= t; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= x) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + x);
                }
            }
            return Math.abs(sum - dp[n][t] - dp[n][t]);
        }

        // 一维优化
        public int lastStoneWeight_OneDimen(int[] stones) {
            int n = stones.length;
            int sum = Arrays.stream(stones).sum();
            int t = sum / 2;
            int[] dp = new int[t + 1];
            for (int i = 1; i <= n; ++i) {
                int x = stones[i - 1];
                for (int j = t; j >= x; j--) {
                    dp[j] = Math.max(dp[j], dp[j - x] - x);
                }
            }
            return Math.abs(sum - dp[t] - dp[t]);
        }
    }

}