package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 01:09:40</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T62_不同路径 {
    // 朴素
    public int uniquePaths_1(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != 0) dp[i][j] += dp[i - 1][j];
                if (j != 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 滚动数组
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j != 0) dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
