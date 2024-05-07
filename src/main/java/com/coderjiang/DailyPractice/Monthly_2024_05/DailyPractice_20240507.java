package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-07 12:40:24</p>
 */
public class DailyPractice_20240507 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int rows, cols;
        int[][][] memo;

        public int cherryPickup(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            memo = new int[rows][cols][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(grid, 0, 0, cols - 1);
        }

        private int dfs(int[][] grid, int row, int p1, int p2) {
            if (row >= rows) return 0;
            if (memo[row][p1][p2] != -1) return memo[row][p1][p2];
            int res = 0;
            for (int newP1 = p1 - 1; newP1 <= p1 + 1; newP1++) {
                if (newP1 < 0 || newP1 >= cols) continue;
                for (int newP2 = p2 - 1; newP2 <= p2 + 1; newP2++) {
                    if (newP2 < 0 || newP2 >= cols) continue;
                    res = Integer.max(res, dfs(grid, row + 1, newP1, newP2));
                }
            }
            if (p1 == p2) {
                res += grid[row][p1];
            } else {
                res += grid[row][p1] + grid[row][p2];
            }
            return memo[row][p1][p2] = res;
        }
    }

}
