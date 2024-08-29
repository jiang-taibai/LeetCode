package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-29 10:14:50</p>
 */
public class DailyPractice_20240829 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean satisfiesConditions(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i + 1 < rows && grid[i][j] != grid[i + 1][j]) return false;
                    if (j + 1 < cols && grid[i][j] == grid[i][j + 1]) return false;
                }
            }
            return true;
        }
    }

}
