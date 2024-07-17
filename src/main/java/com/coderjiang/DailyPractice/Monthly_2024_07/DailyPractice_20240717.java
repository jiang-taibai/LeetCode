package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-17 10:30:13</p>
 */
public class DailyPractice_20240717 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[][] graph;

        public int numberOfSets(int n, int maxDistance, int[][] roads) {
            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) graph[i][j] = 0;
                    else graph[i][j] = 0x3fffff;
                }
            }
            for (int[] road : roads) {
                int u = road[0], v = road[1], w = road[2];
                // 如果有多条路，选最小的
                int minW = Math.min(graph[u][v], w);
                graph[u][v] = graph[v][u] = minW;
            }
            int res = 0;
            int condition = (1 << n) - 1;
            while (condition >= 0) {
                if (check(n, condition, maxDistance)) res++;
                condition--;
            }
            return res;
        }

        private boolean check(int n, int condition, int maxDistance) {
            int[][] _graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(graph[i], 0, _graph[i], 0, n);
            }
            boolean[] enable = new boolean[n];
            for (int i = 0; i < n; i++) {
                enable[i] = (condition & 1) == 1;
                condition >>= 1;
            }
            for (int k = 0; k < n; k++) {
                if (!enable[k]) continue;
                for (int i = 0; i < n; i++) {
                    if (!enable[i]) continue;
                    for (int j = 0; j < n; j++) {
                        if (!enable[j]) continue;
                        _graph[i][j] = Math.min(_graph[i][j], _graph[i][k] + _graph[k][j]);
                    }
                }
            }
//            System.out.println(Arrays.toString(enable));
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(_graph[i]));
//            }
            for (int i = 0; i < n; i++) {
                if (!enable[i]) continue;
                for (int j = 0; j < n; j++) {
                    if (!enable[j]) continue;
                    if (_graph[i][j] > maxDistance) return false;
                }
            }
            return true;
        }
    }

}
