package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.*;

/**
 * <p>Creation Time: 2021-08-25 00:28:59</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_25 {

    class Solution {

        private final List<List<Integer>> allPath = new ArrayList<>();
        private final Stack<Integer> curPath = new Stack<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            int n = graph.length;
            curPath.add(0);
            dfs(0, n - 1, graph);
            return allPath;
        }

        private void dfs(int cur, int target, int[][] graph) {
            if (cur == target) {
                allPath.add(new ArrayList<>(curPath));
                return;
            }
            for (int next : graph[cur]) {
                curPath.add(next);
                dfs(next, target, graph);
                curPath.pop();
            }
        }
    }

}
