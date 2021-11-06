package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-11-06 08:54:07</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_06 {

    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int total = n * (n + 1) / 2;
            int sum = Arrays.stream(nums).sum();
            return total - sum;
        }
    }

}
