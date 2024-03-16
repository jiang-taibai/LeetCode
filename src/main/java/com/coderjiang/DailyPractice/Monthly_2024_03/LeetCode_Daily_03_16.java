package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2024/3/28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] memo;

        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int nodes = m * n;
            memo = new int[nodes];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 1; j++) {
                    int curNode = calNodeIndex(i, j, n);
                    if (i - 1 >= 0 && grid[i - 1][j + 1] > grid[i][j]) {
                        int nextNode = calNodeIndex(i - 1, j + 1, n);
                        graph.get(curNode).add(nextNode);
                    }
                    if (grid[i][j + 1] > grid[i][j]) {
                        int nextNode = calNodeIndex(i, j + 1, n);
                        graph.get(curNode).add(nextNode);
                    }
                    if (i + 1 < m && grid[i + 1][j + 1] > grid[i][j]) {
                        int nextNode = calNodeIndex(i + 1, j + 1, n);
                        graph.get(curNode).add(nextNode);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                int curNode = calNodeIndex(i, 0, n);
                res = Integer.max(res, maxDepth(graph, curNode, new boolean[nodes]));
            }
            return res;
        }

        private int calNodeIndex(int row, int col, int maxCols) {
            return row * maxCols + col;
        }

        private int maxDepth(List<List<Integer>> graph, int curNode, boolean[] vis) {
            if(memo[curNode]!=0) return memo[curNode];
            int depth = 0;
            for (Integer nextNode : graph.get(curNode)) {
                if (!vis[nextNode]) {
                    vis[nextNode] = true;
                    depth = Integer.max(depth, maxDepth(graph, nextNode, vis) + 1);
                    vis[nextNode] = false;
                }
            }
            return memo[curNode] = depth;
        }
    }

}