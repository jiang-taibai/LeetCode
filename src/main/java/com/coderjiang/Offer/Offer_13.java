package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-17 19:57:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_13 {

    class Solution {

        private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int movingCount(int m, int n, int k) {
            return dfs(0, 0, m, n, k, new boolean[m][n]);
        }

        private int dfs(int x, int y, int m, int n, int k, boolean[][] vis) {
            if (!check(x, y, k)) return 0;
            vis[x][y] = true;
            int totalLength = 0;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || vis[newX][newY]) continue;
                totalLength += dfs(newX, newY, m, n, k, vis);
            }
            return totalLength + 1;
        }

        private boolean check(int x, int y, int k) {
            return sumOfDigit(x) + sumOfDigit(y) <= k;
        }

        private int sumOfDigit(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

}
