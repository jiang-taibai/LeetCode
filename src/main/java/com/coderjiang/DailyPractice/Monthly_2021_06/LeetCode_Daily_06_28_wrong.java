package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_28_wrong {

    class Solution {

        private final int MAX_SIZE = 1000000;
        private final int[] arr = new int[MAX_SIZE];
        private final int[] minLevel = new int[MAX_SIZE];
        private final int NONE = Integer.MAX_VALUE;

        private void init(int source) {
            for (int i = 0; i < MAX_SIZE; i++) {
                arr[i] = i;
                minLevel[i] = NONE;
            }
            minLevel[source] = 1;
        }

        private int find(int son) {
            int father = arr[son];
            while (father != arr[father]) father = arr[father];
            while (father != arr[son]) {
                int next = arr[son];
                arr[son] = father;
                son = next;
            }
            return father;
        }

        private void union(int son1, int son2) {
            int f1 = find(son1);
            int f2 = find(son2);
            int curMinLevel = Math.min(minLevel[son1], minLevel[son2]);
            // 如果已经有了深度，就说明已经有了通路，这时候深度+1
            if (curMinLevel != NONE) {
                curMinLevel++;
            }
            if (f1 < f2) {
                arr[son2] = f1;
                syncLevel(f1, curMinLevel);
            } else if (f1 > f2) {
                arr[son1] = f2;
                syncLevel(f2, curMinLevel);
            }
        }

        private void syncLevel(int father, int level) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (find(i) == father) {
                    minLevel[i] = level;
                }
            }
        }

        public int numBusesToDestination(int[][] routes, int source, int target) {
            init(source);
            for (int i = 0; i < routes.length; i++) {
                for (int j = 0; j < routes[i].length - 1; j++) {
                    union(routes[i][j], routes[i][j + 1]);
                }
            }
            return minLevel[target];
        }
    }

}