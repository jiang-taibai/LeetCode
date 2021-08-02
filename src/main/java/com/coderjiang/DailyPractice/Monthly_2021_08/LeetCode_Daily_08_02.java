package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-08-02 16:27:10</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_02 {

    class Solution {

        private int[][] map;
        private static final int DISCONNECT = Integer.MAX_VALUE;

        public int networkDelayTime(int[][] times, int n, int k) {
            buildMap(times, n + 1);
            int[] distances = dijkstra(k, n + 1);
            System.out.println(Arrays.toString(distances));
            int max = -1;
            for (int i = 1; i < n; i++) {
                if (i == k) continue;
                max = Math.max(max, distances[i]);
            }
            return max == DISCONNECT ? -1 : max;
        }

        private void buildMap(int[][] times, int n) {
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], DISCONNECT);
            }
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                map[from][to] = time[2];
            }
        }

        private int[] dijkstra(int start, int n) {
            int[] distances = new int[n];
            boolean[] vis = new boolean[n];
            Arrays.fill(distances, DISCONNECT);
            Arrays.fill(vis, false);
            if (n - 1 >= 0) {
                System.arraycopy(map[start], 1, distances, 1, n - 1);
            }
            vis[start] = true;
            while (true) {
                int minDis = DISCONNECT;
                int index = -1;
                for (int i = 1; i < n; ++i) {
                    if (!vis[i] && distances[i] < minDis) {
                        minDis = distances[i];
                        index = i;
                    }
                }
                if (index == -1) break;
                vis[index] = true;
                for (int i = 1; i < n; ++i) {
                    if (!vis[i] && map[index][i] != DISCONNECT && minDis + map[index][i] < distances[i]) {
                        distances[i] = minDis + map[index][i];
                    }
                }
            }
            return distances;
        }
    }

}
