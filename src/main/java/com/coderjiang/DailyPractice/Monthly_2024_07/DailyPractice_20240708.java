package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-08 12:58:40</p>
 */
public class DailyPractice_20240708 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
                sum += nums[i];
            }
            for (int i = 0; i < n; i++) {
                if ((sum - nums[i]) % 2 != 0) continue;
                if (preSum[i] == (sum - nums[i]) / 2) return i;
            }
            return -1;
        }
    }

}
