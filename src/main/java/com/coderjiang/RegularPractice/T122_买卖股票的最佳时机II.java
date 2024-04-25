package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-14 03:05:44</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T122_买卖股票的最佳时机II {

    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // dp[i][0]: 表示到第i天，未购入股票时，可以获得的最大收益
            // dp[i][1]: 表示到第i天，购入股票时，可以获得的最大收益
            int[][] dp = new int[n][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                // int profit = Integer.MIN_VALUE;
                // for (int j = 0; j < i; ++j) {
                //     profit = Math.max(profit, dp[j][1] + prices[i]);
                // }
                // dp[i][0] = Math.max(profit, dp[i - 1][0]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            for (int i = 0; i < n; ++i) {
                System.out.printf("%d\t", dp[i][0]);
            }
            System.out.println();
            for (int i = 0; i < n; ++i) {
                System.out.printf("%d\t", dp[i][1]);
            }
            return Math.max(0, dp[n - 1][0]);
        }
    }

}
