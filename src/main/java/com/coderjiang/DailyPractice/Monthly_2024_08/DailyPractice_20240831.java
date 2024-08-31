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
            int bCount = 0, wCount = 0;
            int lt = grid[i][j] == 'B' ? bCount++ : wCount++;
            int lb = grid[i + 1][j] == 'B' ? bCount++ : wCount++;
            int rt = grid[i][j + 1] == 'B' ? bCount++ : wCount++;
            int rb = grid[i + 1][j + 1] == 'B' ? bCount++ : wCount++;
            return bCount >= 3 || wCount >= 3;
        }
    }

}
