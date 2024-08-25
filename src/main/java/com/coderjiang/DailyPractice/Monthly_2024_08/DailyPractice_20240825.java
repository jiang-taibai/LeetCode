package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-25 10:32:51</p>
 */
public class DailyPractice_20240825 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<Integer, Map<Integer, Boolean>> memo = new HashMap<>();

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sumOfSet = Arrays.stream(nums).sum();
            if (sumOfSet % k != 0) return false;
            int sumOfSubset = sumOfSet / k;
            return dfs(0, 0, sumOfSubset, nums);
        }

        private boolean dfs(int state, int curSum, int targetSum, int[] nums) {
            int n = nums.length;
            if (state + 1 == (1 << n) && curSum == 0) return true;
            String key = String.format("%d,%d", state, curSum);
            if (memo.containsKey(state) && memo.get(state).containsKey(curSum)) return memo.get(state).get(curSum);
            boolean res = false;
            for (int i = 0; i < n; i++) {
                if ((state & (1 << i)) == 0) {
                    if (curSum + nums[i] < targetSum) {
                        res = res || dfs((state | (1 << i)), curSum + nums[i], targetSum, nums);
                    } else if (curSum + nums[i] == targetSum) {
                        res = res || dfs((state | (1 << i)), 0, targetSum, nums);
                    }
                }
            }
            memo.putIfAbsent(state, new HashMap<>());
            memo.get(state).put(curSum, res);
            return res;
        }
    }

}
