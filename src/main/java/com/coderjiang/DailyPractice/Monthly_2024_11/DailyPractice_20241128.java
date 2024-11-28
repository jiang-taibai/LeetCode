package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-28 10:46:04</p>
 */
public class DailyPractice_20241128 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[][][] memo;
        public static int MOD = (int) (1e9 + 7);

        public int countOfPairs(int[] nums) {
            int n = nums.length;
            memo = new int[n+1][55][55];
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo[i].length; j++) {
                    Arrays.fill(memo[i][j], -1);
                }
            }
            return dfs(nums, 0, 0, 50) % MOD;
        }

        private int dfs(int[] nums, int index, int pre1, int pre2) {
            int n = nums.length;
            if (index >= n) return 1;
            if(memo[index][pre1][pre2] != -1) return memo[index][pre1][pre2];
            int num = nums[index];
            int res = 0;
            for (int num1 = pre1; num1 <= num; num1++) {
                int num2 = num - num1;
                if(num2 > pre2) continue;
                res += dfs(nums, index + 1, num1, num - num1) % MOD;
                res %= MOD;
            }
            memo[index][pre1][pre2] = res;
            return res;
        }
    }

}
