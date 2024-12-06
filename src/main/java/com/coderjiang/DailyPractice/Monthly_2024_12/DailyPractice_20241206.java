package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-06 08:41:08</p>
 */
public class DailyPractice_20241206 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numRookCaptures(char[][] board) {
            int row = -1, col = -1;
            int rows = board.length, cols = board[0].length;
            search:
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'R') {
                        row = i;
                        col = j;
                        break search;
                    }
                }
            }
            int res = 0;
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] direction : directions) {
                int i = row, j = col;
                move:
                while (i >= 0 && i < rows && j >= 0 && j < cols) {
                    switch (board[i][j]) {
                        case 'p':
                            res++;
                            break move;
                        case 'B':
                            break move;
                    }
                    i += direction[0];
                    j += direction[1];
                }
            }
            return res;
        }
    }

}
