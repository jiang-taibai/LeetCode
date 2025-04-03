package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-03 12:38:14</p>
 */
public class DailyPractice_20250403 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            long res = -1;
            long preMaxDiff = nums[0] - nums[1];
            int preMaxNum = Math.max(nums[0], nums[1]);
            for(int i = 2; i < n; ++i) {
                res = Math.max(res, preMaxDiff * nums[i]);
                if(nums[i] >= preMaxNum) {
                    preMaxNum = nums[i];
                } else {
                    preMaxDiff = Math.max(preMaxDiff, preMaxNum - nums[i]);
                }
            }
            return res < 0 ? 0 : res;
        }
    }

}
