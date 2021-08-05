package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.*;

/**
 * <p>Creation Time: 2021-08-05 14:01:00</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_05 {

    /**
     * 暴力求解，如果搜索层数大于最大点数，就说明是个环
     */
    class Solution1 {

        private int[][] graph;
        private final Map<Integer, Boolean> map = new HashMap<>();
        private static final int MAX_LEVEL = 10000 + 10;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            this.graph = graph;
            List<Integer> list = new ArrayList<>();
            int n = graph.length;
            for (int i = 0; i < n; i++) {
                if (dfs(i, 0)) list.add(i);
            }
            return list;
        }

        private boolean dfs(int cur, int level) {
            if (map.containsKey(cur)) return map.get(cur);
            if (graph[cur].length == 0) return true;
            if (level >= MAX_LEVEL) return false;

            for (int next : graph[cur]) {
                if (!dfs(next, level + 1)) {
                    map.put(cur, false);
                    return false;
                }
            }
            map.put(cur, true);
            return true;
        }
    }

    /**
     * Solution1的优化版，三色标记法
     */
    class Solution2 {

        private static final int YetSearch = 0;
        private static final int Searching = 1;
        private static final int Searched = 2;

        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (!dfs(graph, color, i)) {
                    list.add(i);
                }
            }
            return list;
        }

        private boolean dfs(int[][] graph, int[] color, int cur) {
            if (color[cur] > 0) {
                return color[cur] == Searched;
            }
            color[cur] = Searching;
            for (int next : graph[cur]) {
                if (!dfs(graph, color, next)) {
                    return false;
                }
            }
            color[cur] = Searched;
            return true;
        }
    }

    /**
     * 拓扑排序法
     */
    class Solution3 {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<List<Integer>> rg = new ArrayList<>();
            int[] inDegree = new int[n];
            for (int i = 0; i < n; i++) {
                rg.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j : graph[i]) {
                    rg.get(j).add(i);
                }
                inDegree[i] = graph[i].length;
            }
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if(inDegree[i] == 0) que.offer(i);
            }
            while (!que.isEmpty()) {
                int cur = que.poll();
                for (Integer next : rg.get(cur)) {
                    if(--inDegree[next] == 0) que.offer(next);
                }
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if(inDegree[i] == 0) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
