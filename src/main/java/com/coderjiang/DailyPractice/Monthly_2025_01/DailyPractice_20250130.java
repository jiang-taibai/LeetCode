package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-30 16:50:20</p>
 */
public class DailyPractice_20250130 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = count(nums1), map2 = count(nums2);
            ArrayList<Integer> res = new ArrayList<>();
            for (Integer num : map1.keySet()) {
                for (int i = 0; i < Math.min(map1.getOrDefault(num, 0), map2.getOrDefault(num, 0)); i++) {
                    res.add(num);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }

        private Map<Integer, Integer> count(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return map;
        }
    }

}
