package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.*;

/**
 * <p>Creation Time: 2024/2/29</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_29 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int rootCount(int[][] edges, int[][] guesses, int k) {
            int n = edges.length + 1;
            List<Integer>[] G = new List[n];
            Set<Long> guessesSet = new HashSet<>();
            init(edges, guesses, n, G, guessesSet);
            Map<Long, Integer> memo = new HashMap<>();
            int res = 0;
            int hit = countHit(0, G, guessesSet, new boolean[n]);
            System.out.println("hit = " + hit);
            return dfs(hit, 0, G, guessesSet, k, new boolean[n]);
        }

        private long hashKey(int u, int v) {
            return u * 100000L + v;
        }

        private void init(int[][] edges, int[][] guesses, int n,
                          List<Integer>[] G, Set<Long> guessesSet) {
            for (int i = 0; i < n; i++) {
                G[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                G[u].add(v);
                G[v].add(u);
            }
            for (int[] guess : guesses) {
                int u = guess[0], v = guess[1];
                guessesSet.add(hashKey(u, v));
            }
        }

        private int countHit(int root, List<Integer>[] G,
                             Set<Long> guesses, boolean[] vis) {
            vis[root] = true;
            List<Integer> nextNode = G[root];
            int hit = 0;
            int subHit = 0;
            for (Integer node : nextNode) {
                if (!vis[node]) {
                    if (guesses.contains(hashKey(root, node))) {
                        hit++;
//                        System.out.printf("%d -> %d\n", root, node);
                    }
                    subHit += countHit(node, G, guesses, vis);
                }
            }
            return hit + subHit;
        }

        private int dfs(int hit, int root, List<Integer>[] G, Set<Long> guesses, int k, boolean[] vis) {
            vis[root] = true;
            List<Integer> nextNode = G[root];
            int res = 0;
            if (hit >= k) {
                res = 1;
//                System.out.println("root = " + root);
            }
            for (Integer node : nextNode) {
                if (!vis[node]) {
                    vis[node] = true;
                    int newHit = hit;
                    if (guesses.contains(hashKey(root, node))) newHit--;
                    if (guesses.contains(hashKey(node, root))) newHit++;
                    res += dfs(newHit, node, G, guesses, k, vis);
                }
            }
            return res;
        }
    }

}
