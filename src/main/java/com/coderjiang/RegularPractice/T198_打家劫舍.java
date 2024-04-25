package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 12:31:50</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T198_打家劫舍 {

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            // dp[i]: 偷到第i家时的最高金额
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Integer.max(nums[0], nums[1]);
            for (int i = 2; i < n; ++i) {
                dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[n - 1];
        }
    }

}
