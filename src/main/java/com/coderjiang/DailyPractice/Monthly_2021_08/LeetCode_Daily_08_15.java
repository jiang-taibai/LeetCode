package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-15 11:33:26</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_15 {

    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int[][][] dp = new int[maxMove + 1][m][n];
            dp[0][startRow][startColumn] = 1;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int outCount = 0;
            for (int i = 0; i < maxMove; ++i) {
                for (int j = 0; j < m; ++j) {
                    for (int k = 0; k < n; ++k) {
                        int count = dp[i][j][k];
                        if (count > 0) {
                            for (int[] direction : directions) {
                                int j1 = j + direction[0];
                                int k1 = k + direction[1];
                                int MOD = 1000000000 + 7;
                                if (j1 >= 0 && k1 >= 0 && j1 < m && k1 < n) {
                                    dp[i + 1][j1][k1] += count;
                                    dp[i + 1][j1][k1] %= MOD;
                                } else {
                                    outCount += count;
                                    outCount %= MOD;
                                }
                            }
                        }
                    }
                }
            }
            return outCount;
        }
    }
}
