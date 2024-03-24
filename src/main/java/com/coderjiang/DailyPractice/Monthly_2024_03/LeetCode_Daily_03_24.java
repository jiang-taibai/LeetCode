package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/4/14</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_24 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private static final int UNABLE = 0x3f3f3f3f;

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, UNABLE);
            dp[0] = 0;
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
                }
            }
            return dp[amount] == UNABLE ? -1 : dp[amount];
        }
    }

}
