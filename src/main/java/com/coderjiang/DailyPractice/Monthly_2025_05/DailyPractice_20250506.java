package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.PriorityQueue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-07 13:05:44</p>
 */
public class DailyPractice_20250506 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] buildArray(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                res[i] = nums[nums[i]];
            }
            return res;
        }
    }

}
