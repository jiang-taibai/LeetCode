package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-13 08:41:03</p>
 */
public class DailyPractice_20241213 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            for (int i = 0; i < nums.length; i++) {
                pq.add(new int[]{nums[i], i});
            }
            for (int i = 0; i < k; i++) {
                int[] minNumItem = pq.poll();
                assert minNumItem != null;
                minNumItem[0] *= multiplier;
                pq.add(minNumItem);
            }
            pq.forEach(item -> nums[item[1]] = item[0]);
            return nums;
        }
    }

}
