package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Creation Time: 2024/3/2</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_02 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            ArrayList<Integer>[] G = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                G[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                G[u].add(v);
                G[v].add(u);
            }
            Set<Integer> restrictedSet = new HashSet<>();
            for (int i : restricted) {
                restrictedSet.add(i);
            }
            return dfs(0, G, restrictedSet, new boolean[n]);
        }

        private int dfs(int root, ArrayList<Integer>[] G, Set<Integer> restricted, boolean[] vis) {
            if (vis[root]) return 0;
            vis[root] = true;
            if (restricted.contains(root)) return 0;
            int res = 1;
            List<Integer> nextNode = G[root];
            for (Integer node : nextNode) {
                if (!vis[node]) {
                    res += dfs(node, G, restricted, vis);
                }
            }
            return res;
        }
    }

    static class Solution2 {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            Set<Integer> set = new HashSet<>();
            for (int i : restricted) {
                set.add(i);
            }
            int[] fathers = new int[n];
            int[] sizes = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
                sizes[i] = 1;
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!set.contains(u) && !set.contains(v)) {
                    merge(u, v, fathers, sizes);
                }
            }
            return sizes[find(0, fathers)];
        }

        private int find(int f, int[] a) {
            return a[f] == f ? f : (a[f] = find(a[f], a));
        }

        private int merge(int u, int v, int[] a, int[] s) {
            int fu = find(u, a), fv = find(v, a);
            if (fu != fv) {
                a[fu] = fv;
                s[fv] += s[fu];
            }
            return fv;
        }
    }

}
