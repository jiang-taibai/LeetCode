package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-26 00:21:43</p>
 */
public class DailyPractice_20240726 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                res = Math.min(res, nums[i] - nums[i - 1]);
            }
            return res;
        }
    }

}
