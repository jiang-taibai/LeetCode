package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-08 00:04:07</p>
 */
public class DailyPractice_20240808 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Map<Integer, Integer> count1 = new HashMap<>(), count2 = new HashMap<>();
            Arrays.stream(nums1).forEach(num -> count1.put(num, count1.getOrDefault(num, 0) + 1));
            Arrays.stream(nums2).forEach(num -> count2.put(num, count2.getOrDefault(num, 0) + 1));
            label:
            for (int i = -1000; i <= 1000; i++) {
                for (Map.Entry<Integer, Integer> entry : count1.entrySet()) {
                    int num = entry.getKey(), count = entry.getValue();
                    if (!count2.containsKey(num + i) || count2.get(num + i) != count) continue label;
                }
                return i;
            }
            return 0;
        }
    }

}
