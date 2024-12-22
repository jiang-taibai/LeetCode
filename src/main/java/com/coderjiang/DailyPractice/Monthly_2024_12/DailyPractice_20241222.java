package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-22 09:23:30</p>
 */
public class DailyPractice_20241222 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private static final Map<Integer, Integer> memo = new HashMap<>();

        public int getKth(int lo, int hi, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            });
            for (int i = lo; i <= hi; i++) {
                int step = calSteps(i);
                pq.offer(new int[]{i, step});
                if (pq.size() > k) pq.poll();
            }
            return pq.peek()[0];
        }

        private int calSteps(int x) {
            if (x == 1) return 0;
            if (memo.containsKey(x)) return memo.get(x);
            int nextX;
            if ((x & 1) == 1) {
                nextX = 3 * x + 1;
            } else {
                nextX = x / 2;
            }
            memo.put(x, calSteps(nextX) + 1);
            return memo.get(x);
        }
    }

}
