package com.coderjiang.DailyPractice.Monthly_2024_07;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-18 15:58:02</p>
 */
public class DailyPractice_20240718 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final List<List<int[]>> graph = new ArrayList<>();

        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            initGraph(n, edges);
            return dijkstra(n, disappear);
        }

        private void initGraph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }
        }

        private int[] dijkstra(int n, int[] disappear) {
            final int UNREACHABLE = 0x3fffffff;
            int[] dis = new int[n];
            Arrays.fill(dis, UNREACHABLE);
            boolean[] vis = new boolean[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            for (int[] path : graph.get(0)) {
                int v = path[0], w = path[1];
                if (w >= disappear[v]) continue;
                dis[v] = Math.min(dis[v], w);
            }
            for (int i = 0; i < n; i++) {
                if (dis[i] == UNREACHABLE) continue;
                pq.offer(new int[]{i, dis[i]});
            }
            dis[0] = 0;
            vis[0] = true;
            int count = 1;
            while (!pq.isEmpty() && count < n) {
                int[] minNode = pq.poll();
                int minDis = minNode[1];
                int minIndex = minNode[0];
                if (vis[minIndex]) continue;
                if (minDis >= disappear[minIndex]) continue;
                vis[minIndex] = true;
                count++;
                List<int[]> paths = graph.get(minIndex);
                for (int[] path : paths) {
                    int v = path[0], w = path[1];
                    if (!vis[v] && minDis + w < dis[v]) {
                        if (minDis + w >= disappear[v]) continue;
                        dis[v] = minDis + w;
                        pq.offer(new int[]{v, dis[v]});
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (dis[i] == UNREACHABLE) dis[i] = -1;
            }
            return dis;
        }
    }

}
