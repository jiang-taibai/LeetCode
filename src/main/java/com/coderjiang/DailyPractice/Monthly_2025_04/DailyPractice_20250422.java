package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-22 21:00:48</p>
 */
public class DailyPractice_20250422 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int idealArrays(int n, int maxValue) {
            final int MOD = (int) (1e9 + 7);
            long[] dp = new long[maxValue + 1];
            Arrays.fill(dp, 1);
            System.out.println(Arrays.toString(dp));
            for (int i = n - 1; i >= 1; --i) {
                for (int j = 1; j <= maxValue; ++j) {
                    for (int k = j + j; k <= maxValue; k += j) {
                        dp[j] += dp[k];
                        dp[j] %= MOD;
                    }
                }
                System.out.println(Arrays.toString(dp));
            }
            long res = 0;
            for (int j = 1; j <= maxValue; ++j) {
                res += dp[j];
                res %= MOD;
            }
            return (int) res;
        }
    }

}
