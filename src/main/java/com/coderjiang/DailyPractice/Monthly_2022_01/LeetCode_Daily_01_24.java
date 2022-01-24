package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.*;

/**
 * <p>Creation Time: 2022-01-24 13:18:08</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_24 {

    class Solution {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            boolean[][] connected = new boolean[n + 1][n + 1];
            for (int[] edge : edges) {
                connected[edge[0]][edge[1]] = true;
                connected[edge[1]][edge[0]] = true;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1, 0});
            int[] vis = new int[n + 1];
            vis[1] = 1;
            while (!queue.isEmpty()) {
                Queue<int[]> next = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int node = queue.peek()[0];
                    int curTime = queue.poll()[1];
                    if (((curTime / change) % 2) == 1) {
                        curTime = (curTime / change + 1) * change;
                    }
                    int nextTime = curTime + time;
                    for (int i = 1; i <= n; ++i) {
                        if (connected[node][i] && vis[i] <= 2) {
                            if (i == n && vis[n] == 1) {
                                return nextTime;
                            }
                            next.offer(new int[]{i, nextTime});
                            vis[i]++;
                        }
                    }
                }
                queue = next;
            }
            return 0;
        }
    }

}
