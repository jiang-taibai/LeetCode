package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-24 11:34:06</p>
 */
public class DailyPractice_20241224 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int eatenApples(int[] apples, int[] days) {
            // a[0] 表示个数
            // a[1] 表示保质期，也就是哪一天过期
            // 优先吃保质期最短的
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1];
                return a[0] - b[0];
            });
            int n = days.length;
            int res = 0;
            for (int i = 0; i < n || !pq.isEmpty(); i++) {
                // 删除所有过期的苹果
                while (!pq.isEmpty() && pq.peek()[1] <= i) {
                    pq.poll();
                }
                // 如果还会长苹果
                if (i < n) {
                    if (apples[i] != 0 || days[i] != 0) {
                        pq.offer(new int[]{apples[i], i + days[i]});
                    }
                }
//                while (!pq.isEmpty() && pq.peek()[0] == 0) pq.poll();
                if (!pq.isEmpty()) {
                    int[] cur = pq.poll();
                    if (--cur[0] != 0) {
                        pq.offer(cur);
                    }
                    res++;
                }
            }
            return res;
        }
    }

}
