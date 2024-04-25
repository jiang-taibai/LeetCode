package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 01:21:25</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T63_不同路径II {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) return 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int backup = dp[j];
                    if (i != 0 && obstacleGrid[i - 1][j] == 1) {
                        dp[j] = 0;
                    }
                    if (j != 0 && obstacleGrid[i][j - 1] != 1) dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
}
