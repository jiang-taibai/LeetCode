package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-28 23:05:41</p>
 */
public class DailyPractice_20250428 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countSubarrays(int[] nums, long k) {
            int r = 0;
            long sum = 0;
            int n = nums.length;
            long res = 0;
            for (int l = 0; l < n; ++l) {
                while (r < n && (sum + nums[r]) * (r - l + 1) < k) {
                    sum += nums[r];
                    ++r;
                }
                res += r - l;
                sum -= nums[l];
            }
            return res;
        }
    }

}
