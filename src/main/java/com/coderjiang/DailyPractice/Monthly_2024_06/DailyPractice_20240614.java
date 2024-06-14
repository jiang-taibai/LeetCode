package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-14 00:06:08</p>
 */
public class DailyPractice_20240614 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maxScore(int[] nums, int x) {
            int n = nums.length;
            long preOdd = 0, preEven = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (!isOdd(nums[i])) {
                    preEven = Math.max(preEven + nums[i], preOdd + nums[i] - x);
                } else {
                    preOdd = Math.max(preOdd + nums[i], preEven + nums[i] - x);
                }
            }
            return isOdd(nums[0]) ? preOdd : preEven;
        }

        private boolean isOdd(int num) {
            return (num & 1) == 1;
        }
    }

}
