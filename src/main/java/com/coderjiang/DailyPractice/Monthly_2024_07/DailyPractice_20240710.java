package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-10 04:28:04</p>
 */
public class DailyPractice_20240710 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
            if (n == 1) return 1;
            else if (n == 2) return 3;

            // 若 startToIncremental[i] 为 True，则表示 nums[i, n-1] 为递增数组
            boolean[] startToIncremental = new boolean[n];
            startToIncremental[n - 1] = true;
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) startToIncremental[i] = true;
                else break;
            }

            int res = 1;
            System.out.printf("Remove nums[%02d, %02d]\n", 0, n - 1);
            for (int i = 0; i < n; i++) {
                // 考虑删除 nums[i+1, j-1] 的数组
                // 新数组 nums[0~i, j~n-1] 为严格递增的条件为
                // 1. nums[0~i] 本身为递增数组
                // 2. startToIncremental[j] 为 True
                // 3. nums[i] < nums[j]
                if (i != 0 && nums[i - 1] >= nums[i]) break;    // 不符合条件 1
                if (i != n - 1) {
                    res++;
                    System.out.printf("Remove nums[%02d, %02d]\n", i + 1, n - 1);
                }
                for (int j = n - 1; j > i + 1; j--) {
                    if (!startToIncremental[j]) break;   // 不符合条件 2
                    if (nums[i] >= nums[j]) break; // 不符合条件 3
                    res++;
                    System.out.printf("Remove nums[%02d, %02d]\n", i + 1, j - 1);
                }
            }
            for (int i = 1; i <= n - 1; i++) {
                // 考虑删除 nums[0, i-1] 的数组
                if (startToIncremental[i]) {
                    res++;
                    System.out.printf("Remove nums[%02d, %02d]\n", 0, i - 1);
                }
            }
            return res;
        }
    }

}
