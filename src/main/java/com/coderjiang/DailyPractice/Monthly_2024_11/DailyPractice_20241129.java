package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-29 08:56:09</p>
 */
public class DailyPractice_20241129 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public static int MOD = (int) (1e9 + 7);

        public int countOfPairs(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][1000+1];
            for (int i = 0; i <= nums[0]; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                int d = Math.max(0, nums[i]-nums[i-1]);
                for (int v2 = d; v2 <= nums[i]; v2++) {
                    if (v2 == 0) {
                        dp[i][v2] = dp[i - 1][v2 - d];
                    } else {
                        dp[i][v2] = (dp[i][v2 - 1] + dp[i - 1][v2 - d]) % MOD;
                    }
                }
                // nums[i - 1] - v1 >= nums[i] - v2
                // nums[i - 1] - nums[i] >= v1 - v2
                // v1 <= nums[i - 1] - nums[i] + v2
                // nums[i - 1] - nums[i] <= v1 <= nums[i - 1]
            }
            int res = 0;
            for (int v : dp[n - 1]) res = (res + v) % MOD;
            return res;
        }
    }

}
