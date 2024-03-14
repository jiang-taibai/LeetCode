package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_14 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            long[] longNums = new long[n];
            for (int i = 0; i < n; i++) {
                longNums[i] = nums[i];
            }
            for (int i = n - 1; i >= 1; i--) {
                if (longNums[i] >= longNums[i - 1]) {
                    longNums[i - 1] = longNums[i] + longNums[i - 1];
                }
            }
            return longNums[0];
        }
    }

}
/*
2,3,7,9,3
从后往前合并
2,3,16,9,3
2,19,16,9,3
21,19,16,3

2,100,3
 */
