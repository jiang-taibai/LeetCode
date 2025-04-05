package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-05 12:07:42</p>
 */
public class DailyPractice_20250405 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int subsetXORSum(int[] nums) {
            return dfs(nums, 0, 0);
        }

        private int dfs(int[] nums, int i, int xor) {
            if (i >= nums.length) return xor;
            return dfs(nums, i + 1, xor ^ nums[i]) +
                    dfs(nums, i + 1, xor);
        }
    }

}
