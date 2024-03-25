package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/4/16</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_25 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }

}
