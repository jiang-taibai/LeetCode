package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-27 04:00:30</p>
 */
public class T80_高级数据结构_岛屿数量 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            int rows = grid.length, cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        removeLand(grid, rows, cols, i, j);
                    }
                }
            }
            return res;
        }

        private void removeLand(char[][] grid, int rows, int cols, int row, int col) {
            grid[row][col] = '0';
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] direction : directions) {
                int newRow = row + direction[0], newCol = col + direction[1];
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == '1') {
                    removeLand(grid, rows, cols, newRow, newCol);
                }
            }
        }
    }

}
