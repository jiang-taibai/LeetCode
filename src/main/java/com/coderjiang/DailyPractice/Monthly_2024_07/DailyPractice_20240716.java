package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-16 22:32:25</p>
 */
public class DailyPractice_20240716 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            int[] res = new int[2];
            for (int num : nums1) set1.add(num);
            for (int num : nums2) set2.add(num);
            for (int num : nums1) {
                if (set2.contains(num)) res[0]++;
            }
            for (int num : nums2) {
                if (set1.contains(num)) res[1]++;
            }
            return res;
        }
    }

}
