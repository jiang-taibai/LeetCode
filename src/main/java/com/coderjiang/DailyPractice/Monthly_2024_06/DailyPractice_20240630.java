package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-30 01:22:57</p>
 */
public class DailyPractice_20240630 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        Map<Integer, Integer>[] memo;

        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            memo = new HashMap[n];
            for (int i = 0; i < n; i++) {
                memo[i] = new HashMap<>();
            }
            return dfs(nums, 0, target);
        }

        private int dfs(int[] nums, int i, int target) {
            if (i >= nums.length) {
                if (target == 0) return 1;
                else return 0;
            }
            if (memo[i].containsKey(target)) {
                return memo[i].get(target);
            }
            int res = dfs(nums, i + 1, target - nums[i]) + dfs(nums, i + 1, target + nums[i]);
            memo[i].put(target, res);
            return res;
        }

    }

}
