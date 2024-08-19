package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-19 09:53:25</p>
 */
public class DailyPractice_20240819 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int MOD = (int) (1e9 + 7);

        public int checkRecord(int n) {
            // dp[i][j][k] 表示第 i 天，已经连续 j 天迟到，总共缺勤 k 次的
            // 可获得出勤奖励的组合数量
            int[][][] dp = new int[n + 1][3][2];
            dp[0][0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= 2; j++) {
                    dp[i][0][0] += dp[i - 1][j][0];
                    dp[i][0][1] += (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                    dp[i][0][0] %= MOD;
                    dp[i][0][1] %= MOD;
                    if (j > 0) {
                        dp[i][j][0] = dp[i - 1][j - 1][0];
                        dp[i][j][1] = dp[i - 1][j - 1][1];
                    }
                }
            }
            int res = 0;
            for (int j = 0; j <= 2; j++) {
                for (int k = 0; k <= 1; k++) {
                    res += dp[n][j][k];
                    res %= MOD;
                }
            }
            return res;
        }
    }

}
