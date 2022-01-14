package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2022-01-14 21:50:24</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_14 {

    class Solution {

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
                return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
            });
            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                pq.offer(new int[]{i, 0});
            }
            List<List<Integer>> result = new ArrayList<>();
            while (k-- > 0 && !pq.isEmpty()) {
                int[] ints = pq.poll();
                List<Integer> pair = new ArrayList();
                pair.add(nums1[ints[0]]);
                pair.add(nums2[ints[1]]);
                result.add(pair);
                if (ints[1] + 1 < nums2.length) {
                    pq.offer(new int[]{ints[0], ints[1] + 1});
                }
            }
            return result;
        }
    }

}
