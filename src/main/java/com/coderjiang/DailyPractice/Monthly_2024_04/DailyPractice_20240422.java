package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-22 10:42:27</p>
 */
public class DailyPractice_20240422 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] nums;
        private final Map<Integer, Integer> memo = new HashMap<>();

        public int combinationSum4(int[] nums, int target) {
            this.nums = nums;
            return dfs(target);
        }

        private int dfs(int target) {
            if (target < 0) return 0;
            if (target == 0) return 1;
            if(memo.containsKey(target)) {
                return memo.get(target);
            }
            int res = 0;
            for (int num : nums) {
                res += dfs(target - num);
            }
            memo.put(target, res);
            return res;
        }
    }

}
