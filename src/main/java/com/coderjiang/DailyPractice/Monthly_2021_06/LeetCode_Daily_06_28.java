package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.*;

public class LeetCode_Daily_06_28 {

    class Solution {

        private final int MAX_SIZE = 1000000;

        public int numBusesToDestination(int[][] routes, int source, int target) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] route : routes) {
                for (int r1 : route) {
                    Set<Integer> set = map.getOrDefault(r1, new HashSet<>());
                    for (int r2 : route) {
                        if (r1 != r2) {
                            set.add(r2);
                        }
                    }
                    map.put(r1, set);
                }
            }

            Queue<Integer> que = new LinkedList<>();
            boolean[] vis = new boolean[MAX_SIZE];
            vis[source] = true;
            int level = 1;
            que.offer(source);
            while(!que.isEmpty()) {
                level++;
                Queue<Integer> next = new LinkedList<>();
                while(!que.isEmpty()) {
                    int cur = que.poll();
                    if(cur == target) {
                        return level;
                    }
                    for (Integer nextPoint : map.get(cur)) {
                        if(!vis[nextPoint]) {
                            next.add(nextPoint);
                            vis[nextPoint] = true;
                        }
                    }
                }
                que = next;
            }
            return -1;
        }
    }

}