package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-06 05:49:23</p>
 */
public class T01_矩阵_生命游戏 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public void gameOfLife(int[][] board) {
            int rows = board.length, cols = board[0].length;
            int[][] oldBoard = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(board[i], 0, oldBoard[i], 0, cols);
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int count = countOfLive(oldBoard, i, j);
                    if (board[i][j] == 1 && (count < 2 || count > 3)) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 0 && count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        private int countOfLive(int[][] board, int i, int j) {
            final int[][] directions = new int[][]{
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1}, {0, 1},
                    {1, -1}, {1, 0}, {1, 1},
            };
            int rows = board.length, cols = board[0].length;
            int count = 0;
            for (int[] direction : directions) {
                int _i = direction[0] + i, _j = direction[1] + j;
                if (_i >= 0 && _j >= 0 && _i < rows && _j < cols) {
                    count += board[_i][_j];
                }
            }
            return count;
        }
    }

}
