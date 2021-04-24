package com.coderjiang.DailyPractice.Monthly_2021_04;

import java.util.Arrays;

/**
 * <p>创建时间：2021/4/24 19:42</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_04_24 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1, 3};
        int target = 32;
        System.out.println("solution.combinationSum4(nums, target) = " + solution.combinationSum4(nums, target));
    }

    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            return dfs(nums, target);
        }

        private int dfs(int[] nums, int target) {
            if (target < 0) return 0;
            if (target == 0) return 1;
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (target < nums[i]) break;
                sum += dfs(nums, target - nums[i]);
            }
            return sum;
        }
    }

}
