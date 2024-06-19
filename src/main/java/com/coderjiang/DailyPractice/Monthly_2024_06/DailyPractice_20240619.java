package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-19 15:31:00</p>
 */
public class DailyPractice_20240619 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[][] memo;

        public int maxIncreasingCells(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            memo = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(memo[i], -1);
            }
            int res = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    res = Math.max(res, dfs(mat, rows, cols, i, j) + 1);
                }
            }
            return res;
        }

        private int dfs(int[][] mat, int rows, int cols, int row, int col) {
            if (memo[row][col] != -1) return memo[row][col];
            int res = 0;
            for (int i = 0; i < cols; i++) {
                if (mat[row][i] > mat[row][col]) {
                    res = Math.max(res, dfs(mat, rows, cols, row, i) + 1);
                }
            }
            for (int i = 0; i < rows; i++) {
                if (mat[i][col] > mat[row][col]) {
                    res = Math.max(res, dfs(mat, rows, cols, i, col) + 1);
                }
            }
            return memo[row][col] = res;
        }
    }

}
