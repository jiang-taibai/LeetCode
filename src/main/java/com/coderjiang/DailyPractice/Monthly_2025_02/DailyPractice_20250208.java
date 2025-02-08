package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-08 21:02:30</p>
 */
public class DailyPractice_20250208 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
            if (obstacleGrid[rows - 1][cols - 1] == 1) return 0;
            int[][] dp = new int[rows][cols];
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    if (i == rows - 1 && j == cols - 1) dp[i][j] = 1;
                    else if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = -1;
                    } else if (i == rows - 1) {
                        if (dp[i][j + 1] == -1) dp[i][j] = -1;
                        else dp[i][j] = 1;
                    } else if (j == cols - 1) {
                        if (dp[i + 1][j] == -1) dp[i][j] = -1;
                        else dp[i][j] = 1;
                    } else {
                        if (dp[i][j + 1] == -1 && dp[i + 1][j] == -1) dp[i][j] = -1;
                        if (dp[i][j + 1] != -1) dp[i][j] += dp[i][j + 1];
                        if (dp[i + 1][j] != -1) dp[i][j] += dp[i + 1][j];
                    }
                }
            }
            return dp[0][0] == -1 ? 0 : dp[0][0];
        }
    }

}
