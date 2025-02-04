package com.coderjiang.DailyPractice.Monthly_2025_02;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-04 18:53:26</p>
 */
public class DailyPractice_20250204 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int oddIndex = 0, evenIndex = 0;
            for (int i = 0; i < n; i += 2) {
                while (oddIndex < n && (nums[oddIndex] & 1) == 0) oddIndex++;
                while (evenIndex < n && (nums[evenIndex] & 1) != 0) evenIndex++;
                res[i] = nums[evenIndex++];
                res[i + 1] = nums[oddIndex++];
            }
            return res;
        }
    }

}
