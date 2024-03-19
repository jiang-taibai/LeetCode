package com.coderjiang.DailyPractice.Monthly_2024_03;

import javafx.util.Pair;

/**
 * <p>Creation Time: 2024/3/19</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_19 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int maximumScore(int[] nums, int k) {
            int lhs = k, rhs = k;
            int n = nums.length;
            int res = nums[k];
            int min = nums[k];
            while (lhs > 0 && rhs < n - 1) {
                if (nums[lhs - 1] >= nums[rhs + 1]) {
                    lhs--;
                    min = Math.min(min, nums[lhs]);
                } else {
                    rhs++;
                    min = Math.min(min, nums[rhs]);
                }
                res = Math.max(res, min * (rhs - lhs + 1));
            }
            while (lhs > 0) {
                lhs--;
                min = Math.min(min, nums[lhs]);
                res = Math.max(res, min * (rhs - lhs + 1));
            }
            while (rhs < n - 1) {
                rhs++;
                min = Math.min(min, nums[rhs]);
                res = Math.max(res, min * (rhs - lhs + 1));
            }
            return res;
        }
    }

}