package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-06 15:14:49</p>
 */
public class DailyPractice_20240906 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int[] nums;
        int k;
        int[][][] memo;

        public int maximumLength(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
            int n = nums.length;
            this.memo = new int[n + 1][n + 1][k + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dfs(nums, k, i, i, 0));
            }
            return res;
        }

        private int dfs(int[] nums, int k, int preIndex, int curIndex, int countOfNotEqual) {
            if (curIndex >= nums.length) return 0;
            if (memo[preIndex][curIndex][countOfNotEqual] != -1) return memo[preIndex][curIndex][countOfNotEqual];
            int len = 0;
            if (nums[preIndex] != nums[curIndex] && countOfNotEqual < k) {
                len = Math.max(len, dfs(nums, k, curIndex, curIndex + 1, countOfNotEqual + 1) + 1);
            } else if (nums[preIndex] == nums[curIndex]) {
                len = Math.max(len, dfs(nums, k, curIndex, curIndex + 1, countOfNotEqual) + 1);
            }
            len = Math.max(len, dfs(nums, k, preIndex, curIndex + 1, countOfNotEqual));
            memo[preIndex][curIndex][countOfNotEqual] = len;
            return len;
        }
    }

}
