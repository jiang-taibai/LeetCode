package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/3/26</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_26 {

    public static void main(String[] args) {

    }

    static class Graph {

        private final int n;
        private final int[][] map;
        private static final int UNREACHABLE = Integer.MAX_VALUE / 2;

        public Graph(int n, int[][] edges) {
            this.n = n;
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], UNREACHABLE);
            }
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            map[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int from, int to) {
            int[] cost = new int[n];
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                cost[i] = map[from][i];
            }
            cost[from] = 0;
            vis[from] = true;
            for (int i = 0; i < n; i++) {
                int minCost = UNREACHABLE;
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
                    if (!vis[j] && map[minIndex][j] != UNREACHABLE) {
                        int newCost = minCost + map[minIndex][j];
                        if (newCost < cost[j]) {
                            cost[j] = newCost;
                        }
                    }
                }
            }
            return cost[to] == UNREACHABLE ? -1 : cost[to];
        }
    }

}
