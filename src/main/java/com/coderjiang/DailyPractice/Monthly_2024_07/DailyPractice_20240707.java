package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-07 14:44:56</p>
 */
public class DailyPractice_20240707 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int rows, cols;

        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            rows = board.length;
            cols = board[0].length;
            int[][] directions = new int[][]{
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                    {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
            };
            for (int[] direction : directions) {
                int i = rMove + direction[0], j = cMove + direction[1];
                int len = 0;
                while (checkIndex(i, j) && isContrary(board[i][j], color)) {
                    i += direction[0];
                    j += direction[1];
                    len++;
                }
                if (!checkIndex(i, j)) continue;
                // 此时 i, j 如果合理，那么在另一个端点处
                if (len > 0 && board[i][j] == color) return true;
            }
            return false;
        }

        private boolean checkIndex(int i, int j) {
            return i >= 0 && j >= 0 && i < rows && j < cols;
        }

        private boolean isContrary(char c1, char c2) {
            return (c1 == 'W' && c2 == 'B') || (c1 == 'B' && c2 == 'W');
        }

    }

}
