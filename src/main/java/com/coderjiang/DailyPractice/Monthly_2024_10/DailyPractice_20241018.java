package com.coderjiang.DailyPractice.Monthly_2024_10;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-18 13:47:44</p>
 */
public class DailyPractice_20241018 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int minOperations(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i <= n - 3; i++) {
                if (nums[i] == 0) {
                    res++;
                    for (int j = i; j < i + 3; j++) {
                        nums[j] = nums[j] == 1 ? 0 : 1;
                    }
                }
            }
            if (nums[n - 1] == 0 || nums[n - 2] == 0) return -1;
            return res;
        }

    }

}
/*
0 0 0 0
3+2+1
n*(n-1)/2
4*3/2
0 0 0
2+1
3*2/2
 */
