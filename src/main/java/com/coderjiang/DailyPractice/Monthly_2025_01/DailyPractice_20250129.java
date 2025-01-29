package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-29 12:54:32</p>
 */
public class DailyPractice_20250129 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (i >= k + 1) {
                    set.remove(nums[i - k - 1]);
                }
                if (set.contains(nums[i])) return true;
                set.add(nums[i]);
            }
            return false;
        }
    }

}
