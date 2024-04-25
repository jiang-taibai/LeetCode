package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 01:27:52</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T64_最小路径和 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[n];
            for (int i = 1; i < n; ++i) {
                dp[i] += dp[i - 1] + grid[0][i - 1];
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (j != 0) dp[j] = Math.min(dp[j - 1] + grid[i][j - 1], dp[j] + grid[i - 1][j]);
                    else dp[j] += grid[i - 1][j];
                }
            }
            return dp[n - 1] + grid[m - 1][n - 1];
        }
    }
}
