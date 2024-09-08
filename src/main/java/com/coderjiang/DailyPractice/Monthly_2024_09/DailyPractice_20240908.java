package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-08 15:25:43</p>
 */
public class DailyPractice_20240908 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                nums[0] *= nums[0];
                return nums;
            }
            int negativePoint = -1, positivePoint = n;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] < 0 && nums[i + 1] >= 0) {
                    negativePoint = i;
                    positivePoint = i + 1;
                    break;
                }
            }
            if (negativePoint == -1) {
                if (nums[0] < 0) negativePoint = n - 1;
                else positivePoint = 0;
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int negativePower = negativePoint == -1 ? Integer.MAX_VALUE : nums[negativePoint] * nums[negativePoint];
                int positivePower = positivePoint == n ? Integer.MAX_VALUE : nums[positivePoint] * nums[positivePoint];
                if (negativePower < positivePower) {
                    negativePoint--;
                    res[i] = negativePower;
                } else {
                    positivePoint++;
                    res[i] = positivePower;
                }
            }
            return res;
        }
    }

}
