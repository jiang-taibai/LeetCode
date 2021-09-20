package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-20 10:28:29</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_20 {

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            // dp[i]表示以nums[i]结尾的最长递增子序列长度
            int[] dp = new int[n];
            int[] cnt = new int[n];
            int maxLen = 1;
            for (int i = 0; i < n; ++i) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] == dp[j] + 1) cnt[i] += cnt[j];
                        else if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                            maxLen = Math.max(maxLen, dp[i]);
                        }
                    }
                }
            }
            int total = 0;
            for (int i = 0; i < n; ++i) {
                if (dp[i] == maxLen) total += cnt[i];
            }
            return total;
        }
    }

}
