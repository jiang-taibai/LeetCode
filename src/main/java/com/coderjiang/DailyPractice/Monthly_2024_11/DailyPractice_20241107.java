package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-07 10:46:04</p>
 */
public class DailyPractice_20241107 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] resultsArray(int[] nums, int k) {
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int len = 1;
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1] + 1) len++;
                else len = 1;
                if (i >= k - 1) {
                    res[i - k + 1] = len < k ? -1 : nums[i];
                }
            }
            return res;
        }
    }

}
