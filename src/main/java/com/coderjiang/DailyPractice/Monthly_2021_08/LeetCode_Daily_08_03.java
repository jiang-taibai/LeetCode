package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-03 12:20:06</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_03 {

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE, right = -1;
            int min = Integer.MAX_VALUE, left = -1;
            for (int i = 0; i < n; i++) {
                if (max > nums[i]) right = i;
                if (min < nums[n - i - 1]) left = n - i - 1;
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[n - i - 1]);
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }

}
