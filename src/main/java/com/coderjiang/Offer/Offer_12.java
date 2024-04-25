package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-17 19:40:50</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_12 {

    class Solution {

        private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, word, 1, new boolean[board.length][board[i].length], i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int indexInWord,
                            boolean[][] vis, int x, int y) {
            if (indexInWord >= word.length()) {
                return true;
            }
            vis[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 &&
                        newX < board.length && newY < board[0].length &&
                        !vis[newX][newY] && board[newX][newY] == word.charAt(indexInWord)) {
                    if (dfs(board, word, indexInWord + 1, vis, newX, newY)) return true;
                }
            }
            vis[x][y] = false;
            return false;
        }
    }

}
