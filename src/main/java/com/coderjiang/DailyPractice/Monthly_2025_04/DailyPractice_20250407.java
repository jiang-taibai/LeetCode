package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-07 13:31:23</p>
 */
public class DailyPractice_20250407 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;
            int target = sum / 2;
            Arrays.sort(nums);
            boolean[][] dp = new boolean[n + 1][sum + 1];
            int preSum = nums[0];
            dp[0][0] = true;
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j <= preSum; ++j) {
                    if (dp[i - 1][j]) {
                        dp[i][j] = dp[i][j + nums[i]] = true;
                        if (j == target || j + nums[i] == target) return true;
                    }
                }
                preSum += nums[i];
            }
            return false;
        }
    }

}
