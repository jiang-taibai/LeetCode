package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-17 09:32:04</p>
 */
public class DailyPractice_20240917 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private static final int INF = 0x3fffffff;

        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            boolean[][] graph = initGraph(routes);
            List<Integer> sourceBuses = new ArrayList<>();
            List<Integer> targetBuses = new ArrayList<>();
            for (int i = 0; i < routes.length; i++) {
                for (int bus : routes[i]) {
                    if (source == bus) sourceBuses.add(i);
                    else if (target == bus) targetBuses.add(i);
                }
            }
            int res = INF;
            for (Integer sourceBus : sourceBuses) {
                for (Integer targetBus : targetBuses) {
                    res = Math.min(res, bfs(graph, sourceBus, targetBus));
                }
            }
            return res == INF ? -1 : res;
        }

        private boolean[][] initGraph(int[][] routes) {
            Map<Integer, List<Integer>> stations = new HashMap<>();
            for (int i = 0; i < routes.length; ++i) {
                for (int station : routes[i]) {
                    stations.putIfAbsent(station, new ArrayList<>());
                    stations.get(station).add(i);
                }
            }
            int n = routes.length;
            boolean[][] graph = new boolean[n][n];
            for (List<Integer> value : stations.values()) {
                for (int i = 0; i < value.size(); i++) {
                    int u = value.get(i);
                    for (int j = i + 1; j < value.size(); j++) {
                        int v = value.get(j);
                        graph[u][v] = graph[v][u] = true;
                    }
                }
            }
            return graph;
        }

        private int bfs(boolean[][] graph, int source, int target) {
            if (source == target) return 1;
            boolean[] vis = new boolean[graph.length + 1];
            Queue<Integer> cur = new LinkedList<>();
            cur.offer(source);
            vis[source] = true;
            int res = 1;
            while (!cur.isEmpty()) {
                Queue<Integer> next = new LinkedList<>();
                while (!cur.isEmpty()) {
                    int bus = cur.poll();
                    for (int nextBus = 0; nextBus < graph[bus].length; nextBus++) {
                        if (graph[bus][nextBus]) {
                            if (nextBus == target) return res + 1;
                            if (!vis[nextBus]) {
                                vis[nextBus] = true;
                                next.offer(nextBus);
                            }
                        }
                    }
                }
                cur = next;
                res++;
            }
            return -1;
        }

    }

}
