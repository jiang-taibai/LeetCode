package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * <p>Creation Time: 2024/4/9</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_09 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximumCount(int[] nums) {
            int positive = 0, negative = 0;
            for (int num : nums) {
                if (num > 0) positive++;
                else if (num < 0) negative++;
            }
            return Math.max(positive, negative);
        }
    }

}
