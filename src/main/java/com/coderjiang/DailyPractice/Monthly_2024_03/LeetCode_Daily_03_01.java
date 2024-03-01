package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/1</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                if (i >= 1 && subArrayIsValid(nums, i - 1, i)) {
                    dp[i + 1] = dp[i + 1 - 1 - 1];
                }
                if (i >= 2 && subArrayIsValid(nums, i - 2, i)) {
                    dp[i + 1] = dp[i + 1] || dp[i + 1 - 2 - 1];
                }
            }
            return dp[n];
        }

        private boolean subArrayIsValid(int[] nums, int l, int r) {
            if (l < 0 || r >= nums.length) return false;
            // 如果是两个元素
            if (r - l == 1) {
                return nums[l] == nums[r];
            } else if (r - l == 2) {
                return (nums[l] == nums[l + 1] && nums[l] == nums[l + 2]) ||
                        (nums[l] == nums[l + 1] - 1 && nums[l] == nums[l + 2] - 2);
            }
            return false;
        }
    }

}
