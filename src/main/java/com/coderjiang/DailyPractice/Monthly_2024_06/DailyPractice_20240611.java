package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-11 14:21:12</p>
 */
public class DailyPractice_20240611 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countBattleships(char[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int res = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'X') {
                        cleanShip(board, i, j, rows, cols);
                        res++;
                    }
                }
            }
            return res;
        }

        private void cleanShip(char[][] board, int i, int j, int rows, int cols) {
            board[i][j] = '.';
            while (i + 1 < rows && board[i + 1][j] == 'X') board[++i][j] = '.';
            while (j + 1 < cols && board[i][j + 1] == 'X') board[i][++j] = '.';
        }
    }

}
