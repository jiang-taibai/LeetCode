package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-24 13:08:34</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_24 {

    class Solution {

        private int[][] map;
        private int[][] memo;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            map = new int[n][n];
            memo = new int[n][k];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    map[i][j] = -1;
                }
            }
            for (int[] flight : flights) {
                map[flight[0]][flight[1]] = flight[2];
            }
            return dfs(n, src, dst, k);
        }

        private int dfs(int n, int src, int dst, int k) {
            if (k != -1 && memo[src][k] != 0) return memo[src][k];
            if (src == dst) {
                return 0;
            }
            if (k == -1) {
                return -1;
            }
            int minDis = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (map[src][i] != -1) {
                    int dis = dfs(n, i, dst, k - 1);
                    if (dis != -1) {
                        minDis = Math.min(minDis, dis + map[src][i]);
                    }
                }
            }
            if (minDis == Integer.MAX_VALUE) return memo[src][k] = -1;
            return memo[src][k] = minDis;
        }
    }

}
