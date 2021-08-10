package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-10 10:42:02</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_10 {

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                int sub = nums[i + 1] - nums[i];
                int len = 2;
                for (int j = i + 2; j < n; j++) {
                    if (nums[j] - nums[j - 1] == sub) len++;
                    else break;
                }
                for (int j = 2; j <= len - 1; ++j) {
                    res += len - j;
                }
            }
            return res;
        }

    }

}
