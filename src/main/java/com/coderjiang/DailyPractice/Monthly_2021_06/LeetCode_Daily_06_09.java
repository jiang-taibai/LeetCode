package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_09 {

    class Solution {
        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            int m = group.length;
            int MOD = 1000000000 + 7;
            // dp[i][j][k] 表示 做前i个范围内的任务，如果用到了j个人，且获利了k的情况下的方案数量
            int[][][] dp = new int[m + 1][n + 1][minProfit + 1];
            for (int i = 1; i <= m; i++) {
                int perGroup = group[i - 1];
                int perProfit = profit[i - 1];
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= minProfit; k++) {
                        if (j < perGroup) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - perGroup][Math.max(0, k - perProfit)]) % MOD;
                        }
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += dp[m][i][minProfit];
                sum %= MOD;
            }
            return sum;
        }
    }

}