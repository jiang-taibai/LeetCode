package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-22 17:01:37</p>
 */
public class DailyPractice_20250116 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length;
            int res = n + 1;
            for (int i = 0; i < n; i++) {
                int orSum = 0;
                for (int j = i; j < n; j++) {
                    orSum = orSum | nums[j];
                    if (orSum >= k) res = Math.min(res, j - i + 1);
                }
            }
            return res == n + 1 ? -1 : res;
        }
    }

}
