package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Arrays;

/**
 * <p>创建时间：2021/5/13 12:10</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_13 {

    class Solution {
        public static final long mod = 1000000000 + 7;
        public long[][] memory;

        public int numWays_dfs(int steps, int arrLen) {
            memory = new long[steps + 1][steps + 1];
            for (long[] longs : memory) {
                Arrays.fill(longs, -1);
            }
            return (int) dfs(steps, arrLen, 0);
        }

        private long dfs(int restSteps, int arrLen, int curIndex) {
            if (curIndex >= arrLen || curIndex < 0) return 0;
            if (memory[restSteps][curIndex] != -1) return memory[restSteps][curIndex];
            if (restSteps == 0) {
                return curIndex == 0 ? 1 : 0;
            }
            long res = (dfs(restSteps - 1, arrLen, curIndex - 1) % mod) +
                    (dfs(restSteps - 1, arrLen, curIndex) % mod) +
                    (dfs(restSteps - 1, arrLen, curIndex + 1) % mod);
            res %= mod;
            memory[restSteps][curIndex] = res;
            return res;
        }

        public int numWays_dp(int steps, int arrLen) {
            int maxCols = Math.min(arrLen - 1, steps);
            long[][] dp = new long[steps + 1][maxCols + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= steps; ++i) {
                for (int j = 0; j <= maxCols; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                    }
                    if (j + 1 <= maxCols) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                    }
                }
            }
            return (int) dp[steps][0];
        }

        public int numWays_optimizedDp(int steps, int arrLen) {
            int maxCols = Math.min(arrLen - 1, steps);
            long[] dp = new long[maxCols + 1];
            dp[0] = 1;
            for (int i = 1; i <= steps; ++i) {
                long[] dpNext = new long[maxCols+ 1];
                for (int j = 0; j <= maxCols; j++) {
                    dpNext[j] = dp[j];
                    if (j - 1 >= 0) {
                        dpNext[j] = (dpNext[j] + dp[j - 1]) % mod;
                    }
                    if (j + 1 <= maxCols) {
                        dpNext[j] = (dpNext[j] + dp[j + 1]) % mod;
                    }
                }
                dp = dpNext;
            }
            return (int) dp[0];
        }
    }

}
