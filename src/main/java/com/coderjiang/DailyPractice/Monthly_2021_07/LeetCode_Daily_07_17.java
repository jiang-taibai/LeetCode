package com.coderjiang.DailyPractice.Monthly_2021_07;

/**
 * <p>Creation Time: 2021-07-17 08:06:03</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_17 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if(sum < 0) {
                    sum = 0;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
