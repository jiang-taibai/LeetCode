package com.coderjiang.DailyPractice.Monthly_2025_07;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-28 20:45:39</p>
 */
public class DailyPractice_20250728 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countMaxOrSubsets(int[] nums) {
            int maxNum = 0;
            for(int num : nums) {
                maxNum |= num;
            }
            return dfs(nums, 0, maxNum, 0);
        }

        private int dfs(int[] nums, int num, int maxNum, int index) {
            if(num == maxNum) {
                return 1 << (nums.length - index);
            }
            if(index >= nums.length) return 0;
            return dfs(nums, num | nums[index], maxNum, index + 1) +
                    dfs(nums, num, maxNum, index + 1);
        }
    }

}
