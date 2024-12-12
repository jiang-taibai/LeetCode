package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-12 08:51:00</p>
 */
public class DailyPractice_20241212 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        // 滑动指针
        public long maxSpending_滑动指针(int[][] values) {
            int m = values.length;
            int n = values[0].length;
            int[] indexes = new int[m];
            Arrays.fill(indexes, n - 1);
            long res = 0;
            int day = 0;
            while (day < m * n) {
                int minShopIndex = -1;
                int minShopValue = Integer.MAX_VALUE;
                for (int i = 0; i < m; i++) {
                    if (indexes[i] == -1) continue;
                    if (values[i][indexes[i]] < minShopValue) {
                        minShopValue = values[i][indexes[i]];
                        minShopIndex = i;
                    }
                }
                if (minShopIndex == -1) break;
                res += (long) minShopValue * (day + 1);
                indexes[minShopIndex]--;
                day++;
            }
            return res;
        }

        // 小根堆
        public long maxSpending(int[][] values) {
            int m = values.length;
            int n = values[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> values[a[0]][a[1]]));
            long res = 0;
            int day = 1;
            // init
            for (int i = 0; i < m; i++) {
                pq.add(new int[]{i, n - 1});
            }
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                res += (long) day * values[cur[0]][cur[1]];
                if (cur[1] != 0) {
                    cur[1]--;
                    pq.add(cur);
                }
                day++;
            }
            return res;
        }
    }

}
