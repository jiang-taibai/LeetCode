package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-07-20 08:35:55</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_20 {

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length / 2;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, nums[i] + nums[2 * n - 1 - i]);
            }
            return res;
        }
    }

}
