package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-15 10:29:30</p>
 */
public class DailyPractice_20241215 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minSetSize(int[] arr) {
            int n = arr.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            map.forEach((k, v) -> pq.offer(new int[]{v, k}));
            int res = 0;
            int len = 0;
            while (!pq.isEmpty()) {
                len += pq.poll()[0];
                res++;
                if (len >= n / 2) break;
            }
            return res;
        }
    }

}
