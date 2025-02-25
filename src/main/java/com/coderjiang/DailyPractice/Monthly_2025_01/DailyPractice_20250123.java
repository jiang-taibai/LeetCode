package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-23 15:35:35</p>
 */
public class DailyPractice_20250123 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private Map<Integer, Integer>[] memo;

        public int maximumPoints(int[][] edges, int[] coins, int k) {
            int n = coins.length;
            memo = new Map[n];
            List<List<Integer>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                memo[i] = new HashMap<>();
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            boolean[] vis = new boolean[n];
            vis[0] = true;
            return dfs(graph, coins, k, 0, vis, 0);
        }

        private int dfs(List<List<Integer>> graph, int[] coins, int k,
                        int root, boolean[] vis, int reductions) {
            if (memo[root].containsKey(reductions)) {
                return memo[root].get(reductions);
            }
            int coin = coins[root] >> reductions;
            int condition1 = coin - k;
            for (Integer nextNode : graph.get(root)) {
                if (!vis[nextNode]) {
                    vis[nextNode] = true;
                    condition1 += dfs(graph, coins, k, nextNode, vis, reductions);
                    vis[nextNode] = false;
                }
            }
            int condition2 = coin / 2;
            if (reductions <= 12) {
                for (Integer nextNode : graph.get(root)) {
                    if (!vis[nextNode]) {
                        vis[nextNode] = true;
                        condition2 += dfs(graph, coins, k, nextNode, vis, reductions + 1);
                        vis[nextNode] = false;
                    }
                }
            }
            int res = Math.max(condition1, condition2);
            memo[root].put(reductions, res);
            return res;
        }
    }

}
