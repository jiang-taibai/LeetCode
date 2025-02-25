package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-27 14:15:23</p>
 */
public class DailyPractice_20250127 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                int minSteps = n;
                for (int j = 0; j < i; j++) {
                    if (nums[j] + j >= i) {
                        minSteps = Math.min(minSteps, dp[j] + 1);
                    }
                }
                dp[i] = minSteps;
            }
            return dp[n - 1];
        }
    }

}
