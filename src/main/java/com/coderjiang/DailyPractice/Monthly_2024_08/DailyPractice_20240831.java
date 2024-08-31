package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-31 11:21:39</p>
 */
public class DailyPractice_20240831 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean canMakeSquare(char[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            for (int i = 0; i < rows - 1; i++) {
                for (int j = 0; j < cols - 1; j++) {
                    if (validSquare(grid, i, j)) return true;
                }
            }
            return false;
        }

        private boolean validSquare(char[][] grid, int i, int j) {
            int bCount = 0;
            int[][] directions = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
            for (int[] direction : directions) {
                if (grid[i + direction[0]][j + direction[1]] == 'B') {
                    bCount++;
                }
            }
            return bCount != 2;
        }
    }

}
