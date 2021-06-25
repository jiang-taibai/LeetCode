package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_25 {

    class Solution {

        private static final int MAX_SIZE = 1000 + 10;
        private int[][] map = new int[MAX_SIZE][MAX_SIZE];

        private void connect(int num, int dis) {
            int[] arr = {
                    num / 1000,
                    (num % 1000) / 100,
                    (num % 100) / 10,
                    num % 10
            };

            int next = 0;
            for (int i = 0; i < 4; i++) {
                int temp = arr[i];
                arr[i] = (temp + 1 + 10) % 10;
                next = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
                map[num][next] = map[next][num] = dis;

                arr[i] = (temp - 1 + 10) % 10;
                next = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
                map[num][next] = map[next][num] = dis;
            }
        }


        private int dijkstra(int target) {
            int[] shortest = new int[MAX_SIZE];
            boolean[] vis = new boolean[MAX_SIZE];
            for (int i = 0; i < MAX_SIZE; i++) {
                shortest[i] = map[0][i];
            }
            vis[0] = true;
            while (true) {
                int minDis = Integer.MAX_VALUE;
                int minPoint = -1;
                for (int i = 0; i < MAX_SIZE; i++) {
                    if (!vis[i] && shortest[i] < minDis) {
                        minDis = shortest[i];
                        minPoint = i;
                    }
                }
                if (minPoint == -1) break;
                vis[minPoint] = true;
                for (int i = 0; i < MAX_SIZE; i++) {
                    if (!vis[i] && map[i][minPoint] != Integer.MAX_VALUE &&
                            map[i][minPoint] + minDis < shortest[i]) {
                        shortest[i] = map[i][minPoint] + minDis;
                    }
                }
            }
            return shortest[target];
        }

        public int openLock(String[] deadends, String target) {
            boolean[] cont = new boolean[MAX_SIZE];
            for (String deadend : deadends) {
                cont[Integer.parseInt(deadend)] = true;
            }
            for (int i = 0; i < MAX_SIZE; i++) {
                for (int j = 0; j < MAX_SIZE; j++) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < MAX_SIZE; i++) {
                connect(i, 1);
            }
            for (int i = 0; i < MAX_SIZE; i++) {
                if (cont[i]) {
                    connect(i, Integer.MAX_VALUE);
                }
            }
            int minDis = dijkstra(Integer.parseInt(target));
            return minDis == Integer.MAX_VALUE ? -1 : minDis;
        }
    }

}