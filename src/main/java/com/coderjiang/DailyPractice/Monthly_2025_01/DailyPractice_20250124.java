package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-24 11:14:31</p>
 */
public class DailyPractice_20250124 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public static final int INVALID_PRICE = (int) 1e9;

        public int minimumCoins(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[2][n];
            dp[0][0] = INVALID_PRICE;
            dp[1][0] = prices[0];
            for (int i = 1; i < n; i++) {
                int minPrice = INVALID_PRICE;
                // 先找如果不购买 i 号物品时的最低价格
                for (int j = i / 2; j <= i - 1; j++) {
                    minPrice = Math.min(minPrice, dp[1][j]);
                }
                dp[0][i] = minPrice;
                dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + prices[i];
            }
            return Math.min(dp[0][n - 1], dp[1][n - 1]);
        }
    }

}
/*
3 -> 4 5 6
2 -> 3 4 5
 */
