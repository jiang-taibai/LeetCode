package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-02 16:19:48</p>
 */
public class DailyPractice_20240802 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int[] countRow = new int[rows];
            int[] countCol = new int[cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    countRow[i] += grid[i][j];
                    countCol[j] += grid[i][j];
                }
            }
            long res = 0;
            for (int i = 0; i < rows; i++) {
                if (countRow[i] <= 1) continue;
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0 || countCol[j] <= 1) continue;
                    res += (countRow[i] - 1L) * (countCol[j] - 1);
                }
            }
            return res;
        }
    }

}
