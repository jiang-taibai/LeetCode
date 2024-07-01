package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-01 23:16:59</p>
 */
public class DailyPractice_20240701 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private List<int[]>[] graph;
        private int[] values;
        private int res = 0;

        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            int n = values.length;
            graph = new List[n];
            this.values = values;
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                graph[u].add(new int[]{v, w});
                graph[v].add(new int[]{u, w});
            }
            int[] vis = new int[n];
            vis[0] = 1;
            dfs(0, vis, maxTime);
            return res;
        }

        private void dfs(int node, int[] vis, int maxTime) {
            if (maxTime < 0) return;
            if (node == 0) {
                int sum = 0;
                for (int i = 0; i < vis.length; i++) {
                    sum += vis[i] > 0 ? values[i] : 0;
                }
                this.res = Math.max(this.res, sum);
            }
            for (int[] nextNode : graph[node]) {
                vis[nextNode[0]]++;
                dfs(nextNode[0], vis, maxTime - nextNode[1]);
                vis[nextNode[0]]--;
            }
        }
    }

}
