package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.*;

/**
 * <p>Creation Time: 2022-01-21 15:59:43</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_21 {

    class Solution {

        public int minJumps(int[] arr) {
            int n = arr.length;
            if (n == 1) return 0;
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjacency.add(new ArrayList<>());
            }
            // 构造无向图
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; ++j) {
                    if (j == i + 1 || arr[i] == arr[j]) {
                        adjacency.get(i).add(j);
                        adjacency.get(j).add(i);
                    }
                }
            }
            // 搜索最短距离
            // int minDis = dijkstra(arr, 0, n - 1);
            int minDis = bfs(adjacency, 0, n - 1);
            return minDis;
        }

        private int bfs(List<List<Integer>> adjacency, int from, int end) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] vis = new boolean[adjacency.size()];
            queue.offer(from);
            vis[from] = true;
            int dis = 0;
            while (!queue.isEmpty()) {
                ++dis;
                Queue<Integer> next = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    for (Integer nextIndex : adjacency.get(index)) {
                        if (vis[nextIndex]) continue;
                        if (nextIndex == end) return dis;
                        next.offer(nextIndex);
                        vis[nextIndex] = true;
                    }
                }
                queue = next;
            }
            return 0;
        }

        private boolean connected(int[] arr, int u, int v) {
            return Math.abs(u - v) == 1 || arr[u] == arr[v];
            // return adjacency.get(u).contains(v);
        }

        private int dijkstra(int[] arr, int from, int end) {
            int n = arr.length;
            int[] distance = new int[n];
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; ++i) {
                if (connected(arr, from, i)) distance[i] = 1;
                else distance[i] = Integer.MAX_VALUE;
            }
            distance[from] = 0;
            vis[from] = true;
            while (true) {
                int minDis = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int i = 0; i < n; ++i) {
                    if (!vis[i] && distance[i] < minDis) {
                        minDis = distance[i];
                        minIndex = i;
                    }
                }
                if (minIndex == -1) break;
                vis[minIndex] = true;
                for (int i = 0; i < n; ++i) {
                    if (!vis[i] && connected(arr, minIndex, i) && minDis + 1 < distance[i]) {
                        distance[i] = minDis + 1;
                    }
                }
            }
            return distance[end];
        }
    }

}
