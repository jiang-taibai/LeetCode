package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_10 {

    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int coin = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    for (int k = 0; k <= j; k += coin) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
            return dp[n][amount];
        }

        public int change_ODP(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int coin = coins[i - 1];
                for (int j = amount; j >= 0; j--) {
                    for (int k = coin; k <= j; k += coin) {
                        dp[j] += dp[j - k];
                    }
                }
            }
            return dp[amount];
        }
    }

}