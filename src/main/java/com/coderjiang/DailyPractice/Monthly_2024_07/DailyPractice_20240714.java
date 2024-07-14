package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-14 18:03:29</p>
 */
public class DailyPractice_20240714 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int[] maxOfCol = new int[n], maxOfRow = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maxOfCol[j] = Math.max(maxOfCol[j], grid[i][j]);
                    maxOfRow[i] = Math.max(maxOfRow[i], grid[i][j]);
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += Math.min(maxOfCol[j], maxOfRow[i]) - grid[i][j];
                }
            }
            return res;
        }
    }

}
