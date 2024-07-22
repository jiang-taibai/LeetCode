package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-22 12:44:04</p>
 */
public class DailyPractice_20240722 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private boolean[][] graph;

        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;
            graph = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                for (int j = 0; j < n; j++) {
                    long x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                    if (((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= (r1 * r1)) {
                        graph[i][j] = true;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, bfs(n, i));
            }
            return res;
        }

        private int bfs(int n, int start) {
            boolean[] vis = new boolean[n];
            int count = 1;
            Queue<Integer> cur = new LinkedList<>();
            cur.add(start);
            vis[start] = true;
            while (!cur.isEmpty()) {
                Queue<Integer> next = new LinkedList<>();
                while (!cur.isEmpty()) {
                    int node = cur.poll();
                    for (int i = 0; i < n; i++) {
                        if(!vis[i] && graph[node][i]) {
                            next.add(i);
                            vis[i] = true;
                            count++;
                        }
                    }
                }
                cur = next;
            }
            return count;
        }

    }

}
/*
69,51,7
65,59,3
16+64=80
 */
