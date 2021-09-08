package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2021-09-08 09:17:02</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_08 {

    class Solution {

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            int[][] projects = new int[n][2];
            for (int i = 0; i < n; ++i) {
                projects[i][0] = profits[i];
                projects[i][1] = capital[i];
            }
            Arrays.sort(projects, (a, b) -> (a[0] - b[0]));
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
            int cur = 0;
            for (int i = 0; i < k; ++i) {
                while (cur < n && projects[cur][0] <= w) pq.offer(projects[cur++][1]);
                if (pq.isEmpty()) break;
                else w += pq.poll();
            }
            return w;
        }
    }

}
