package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-14 18:31:19</p>
 */
public class DailyPractice_20241114 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int res = 0;

        public int countGoodNodes(int[][] edges) {
            int n = edges.length;
            List<List<Integer>> graph = buildGraph(edges);
            boolean[] vis = new boolean[n + 1];
            vis[0] = true;
            dfs(0, graph, vis);
            return res;
        }

        private List<List<Integer>> buildGraph(int[][] edges) {
            int n = edges.length;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            return graph;
        }

        private int dfs(int idx, List<List<Integer>> graph, boolean[] vis) {
            int n = vis.length;
            int subCountMark = -1;
            int subCountTotal = 0;
            for (Integer nextIdx : graph.get(idx)) {
                if (!vis[nextIdx]) {
                    vis[nextIdx] = true;
                    int subCount = dfs(nextIdx, graph, vis);
                    subCountTotal += subCount;
                    if (subCountMark == -1) subCountMark = subCount;
                    else if (subCountMark != subCount) {
                        subCountMark = -2;
                    }
                }
            }
            if (subCountMark != -2) res++;
            return subCountTotal + 1;
        }
    }

}
