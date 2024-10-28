package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-28 16:16:32</p>
 */
public class DailyPractice_20241028 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int count = 0;

        public int[] findRedundantDirectedConnection(int[][] edges) {
            int n = edges.length;
            boolean[][] graph = new boolean[n][n];
            int[] in = new int[n];
            boolean existMultiIn = false;
            for (int[] edge : edges) {
                int u = edge[0] - 1, v = edge[1] - 1;
                graph[u][v] = true;
                in[v]++;
                if (in[v] >= 2) existMultiIn = true;
            }
            int root = -1;
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    root = i;
                    break;
                }
            }
            for (int i = edges.length - 1; i >= 0; i--) {
                int u = edges[i][0] - 1, v = edges[i][1] - 1;
                if (existMultiIn && in[v] <= 1) continue;
                graph[u][v] = false;
                if (root == -1 && in[v] == 1) root = v;
                boolean[] vis = new boolean[n];
                vis[root] = true;
                count = 1;
                if (checkTree(graph, vis, root) && count == n) {
                    return edges[i];
                }
                graph[u][v] = true;
                if (root == v && in[v] == 1) root = -1;
            }
            return null;
        }

        private boolean checkTree(boolean[][] graph, boolean[] vis, int node) {
            int n = graph.length;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (graph[node][i]) {
                    if (vis[i]) return false;
                    vis[i] = true;
                    count++;
                    valid = valid && checkTree(graph, vis, i);
                }
            }
            return valid;
        }

    }

}
