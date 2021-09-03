package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.*;

/**
 * <p>Creation Time: 2021-09-03 09:14:58</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_03 {

    class Solution {
        public int[] smallestK_slowly(int[] arr, int k) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] res = new int[k--];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue(); ++i) {
                    if (k < 0) break;
                    res[k--] = entry.getKey();
                }
                if (k < 0) break;
            }
            return res;
        }

        public int[] smallestK(int[] arr, int k) {
            if (k == 0) return new int[0];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int i = 0; i < k; ++i) {
                pq.offer(arr[i]);
            }
            for (int i = k; i < arr.length; ++i) {
                if (pq.peek() > arr[i]) {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < k; ++i) {
                res[i] = pq.poll();
            }
            return res;
        }
    }

}
