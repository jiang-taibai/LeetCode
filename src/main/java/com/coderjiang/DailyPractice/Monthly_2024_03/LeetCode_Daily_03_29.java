package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/29</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_29 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumSum_ViolenceLaw(int[] nums) {
            int n = nums.length;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] >= nums[j]) continue;
                    for (int k = j + 1; k < n; k++) {
                        if (nums[j] <= nums[k]) continue;
                        res = Integer.min(res, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        public int minimumSum(int[] nums) {
            int n = nums.length;
            int[] leftMountain = new int[n];
            int minValue = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] > minValue) leftMountain[i] = nums[i] + minValue;
                else {
                    minValue = nums[i];
                    leftMountain[i] = -1;
                }
            }
            minValue = nums[n - 1];
            int res = Integer.MAX_VALUE;
            for (int i = n - 2; i >= 1; i--) {
                if (nums[i] > minValue) {
                    if (leftMountain[i] != -1) {
                        res = Integer.min(res, leftMountain[i] + minValue);
                    }
                } else {
                    minValue = nums[i];
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

}
