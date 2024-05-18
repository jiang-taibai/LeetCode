package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-18 12:02:42</p>
 */
public class DailyPractice_20240518 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int maxCount = 0;
            int res = Integer.MAX_VALUE;
            for (int divisor : divisors) {
                int count = 0;
                for (int num : nums) {
                    if (num % divisor == 0) count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    res = divisor;
                } else if (count == maxCount) {
                    res = Integer.min(res, divisor);
                }
            }
            return res;
        }
    }

}
