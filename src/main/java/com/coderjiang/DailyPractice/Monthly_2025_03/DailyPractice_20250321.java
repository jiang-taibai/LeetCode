package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-21 10:26:33</p>
 */
public class DailyPractice_20250321 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maximumOr(int[] nums, int k) {
            int n = nums.length;
            long[] preOr = new long[n + 1], postOr = new long[n + 1];
            for (int i = 0; i < n; ++i) {
                preOr[i + 1] = preOr[i] | nums[i];
                if (i > 0) {
                    postOr[n - i - 1] = postOr[n - i] | nums[n - i];
                }
            }
            long res = preOr[n];
            for (int i = 0; i < n; ++i) {
                res = Math.max(res, preOr[i] | postOr[i] | ((long) (nums[i]) << k));
            }
            return res;
        }
    }
}

/*
12=1100
09=1001
如果每个数字的最高位都相同，选择一个数字左移 k 次，尽可能地避免左移后最高位之后的和数组内其他数字重叠
*/
