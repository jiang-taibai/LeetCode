package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 12:49:21</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T213_打家劫舍II {

    class Solution {
        public int rob(int[] nums) {
            return Integer.max(
                    solve(nums, 0, nums.length - 2),
                    solve(nums, 1, nums.length - 1)
            );
        }

        private int solve(int[] nums, int left, int right) {
            int n = right - left + 1;
            int[] dp = new int[n + 1];
            dp[1] = nums[left];
            for (int i = left + 1; i <= right; ++i) {
                dp[i - left + 1] = Integer.max(dp[i - left - 1] + nums[i], dp[i - left]);
            }
            return dp[n];
        }
    }

}
