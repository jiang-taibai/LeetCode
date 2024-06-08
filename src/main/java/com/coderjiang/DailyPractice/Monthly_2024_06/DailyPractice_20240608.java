package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-08 20:35:58</p>
 */
public class DailyPractice_20240608 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final HashMap<Integer, Integer> memo = new HashMap<>();

        public int maxOperations(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int n = nums.length;
            set.add(nums[0] + nums[1]);
            set.add(nums[0] + nums[n - 1]);
            set.add(nums[n - 1] + nums[n - 2]);
            int maxDepth = 0;
            for (Integer target : set) {
                maxDepth = Math.max(maxDepth, dfs(nums, n, 0, n - 1, target));
                memo.clear();
            }
            return maxDepth;
        }

        private int dfs(int[] nums, int n, int lhs, int rhs, int target) {
            int hashCode = hash(lhs, rhs);
            if (memo.containsKey(hashCode)) return memo.get(hashCode);
            int depth = 0;
            if (lhs >= n || rhs < 0) return 0;
            if (lhs + 1 < n && lhs + 1 <= rhs && nums[lhs] + nums[lhs + 1] == target) {
                depth = Math.max(depth, dfs(nums, n, lhs + 2, rhs, target) + 1);
            }
            if (rhs - 1 >= 0 && lhs <= rhs - 1 && nums[rhs] + nums[rhs - 1] == target) {
                depth = Math.max(depth, dfs(nums, n, lhs, rhs - 2, target) + 1);
            }
            if (lhs < rhs && nums[lhs] + nums[rhs] == target) {
                depth = Math.max(depth, dfs(nums, n, lhs + 1, rhs - 1, target) + 1);
            }
            memo.put(hashCode, depth);
            return depth;
        }

        private int hash(int lhs, int rhs) {
            return lhs * 10000 + rhs;
        }
    }

}
