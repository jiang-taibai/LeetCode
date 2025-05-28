package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-28 17:29:24</p>
 */
public class DailyPractice_20250528 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            List<List<Integer>> g1 = buildGrough(edges1);
            List<List<Integer>> g2 = buildGrough(edges2);
            int n = edges1.length + 1, m = edges2.length + 1;
            int[] res = new int[n];
            int maxGroup2 = 0;
            for (int i = 0; i < m; ++i) {
                maxGroup2 = Math.max(maxGroup2, bfs(g2, i, k - 1));
            }
            for (int i = 0; i < n; ++i) {
                res[i] = bfs(g1, i, k) + maxGroup2;
            }
            return res;
        }

        private List<List<Integer>> buildGrough(int[][] edges) {
            int n = edges.length + 1;
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                g.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; ++i) {
                int u = edges[i][0], v = edges[i][1];
                g.get(u).add(v);
                g.get(v).add(u);
            }
            return g;
        }

        private int bfs(List<List<Integer>> g, int root, int k) {
            Queue<Integer> que = new LinkedList<>();
            que.offer(root);
            int n = g.size();
            boolean[] vis = new boolean[n];
            vis[root] = true;
            int count = 0;
            while (k >= 0 && !que.isEmpty()) {
                Queue<Integer> next = new LinkedList<>();
                while (!que.isEmpty()) {
                    int curNode = que.poll();
                    ++count;
                    for (int nextNode : g.get(curNode)) {
                        if (vis[nextNode]) continue;
                        vis[nextNode] = true;
                        next.offer(nextNode);
                    }
                }
                que = next;
                --k;
            }
            return count;
        }
    }
}
