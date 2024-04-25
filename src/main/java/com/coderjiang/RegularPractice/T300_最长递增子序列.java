package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 16:34:19</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T300_最长递增子序列 {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            // dp[j]表示从i到j，并且以j结尾的最长递增子序列
            int[] dp = new int[n];
            int maxLen = 1;
            for (int i = 0; i < n; ++i) {
                dp[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Integer.max(dp[i], dp[j] + 1);
                        if (dp[i] > maxLen) maxLen = dp[i];
                    }
                }
            }
            return maxLen;
        }
    }

}
