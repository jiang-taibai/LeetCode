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
        public static int MOD = (int) (1e9 + 7);

        public int countOfPairs(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][51];
            for (int i = 0; i <= nums[0]; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int v2 = 0; v2 <= nums[i]; v2++) {
                    for (int v1 = 0; v1 <= v2; v1++) {
                        if (nums[i - 1] - v1 >= nums[i] - v2) {
                            dp[i][v2] += dp[i - 1][v1];
                            dp[i][v2] %= MOD;
                        }
                    }
                }
            }
            int res = 0;
            for (int v : dp[n - 1]) res = (res + v) % MOD;
            return res;
        }
    }

}
