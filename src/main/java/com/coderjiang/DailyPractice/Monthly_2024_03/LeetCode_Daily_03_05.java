package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/5</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_05 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private static final long MOD = (long) (1e9 + 7);

        public int countPaths(int n, int[][] roads) {
            int[][] G = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    G[i][j] = -1;
                }
            }
            for (int[] road : roads) {
                int u = road[0], v = road[1], cost = road[2];
                G[u][v] = G[v][u] = cost;
            }
            return (int) dijkstra(0, n - 1, n, G);
        }

        private long dijkstra(int from, int to, int n, int[][] G) {
            long[] cost = new long[n];
            long[] paths = new long[n];
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (G[from][i] != -1) {
                    cost[i] = G[from][i];
                    paths[i] = 1;
                } else {
                    cost[i] = Long.MAX_VALUE;
                    paths[i] = 0;
                }
            }
            cost[from] = 0;
            paths[from] = 1;
            vis[from] = true;
            for (int i = 0; i < n; i++) {
                long minCost = Long.MAX_VALUE;
                int minIndex = -1;
                for (int j = 0; j < n; j++) {
                    if (!vis[j] && cost[j] < minCost) {
                        minCost = cost[j];
                        minIndex = j;
                    }
                }
                if (minIndex == -1) break;
                vis[minIndex] = true;
                for (int j = 0; j < n; j++) {
                    if (!vis[j] && G[minIndex][j] != -1) {
                        long newCost = cost[minIndex] + G[minIndex][j];
                        if (newCost < cost[j]) {
                            cost[j] = newCost;
                            paths[j] = paths[minIndex];
                        } else if (newCost == cost[j]) {
                            paths[j] = (paths[j] + paths[minIndex]) % MOD;
                        }
                    }
                }
            }
            return paths[to];
        }
    }
}
