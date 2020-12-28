package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Arrays;

/**
 * @author 刘江
 * @modifyTime 2020/12/28 13:04
 * @description TODO
 */
public class LeetCode_Daily_12_28 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            k = Math.min(k, n / 2);
            int[][] buy = new int[n][k];
            int[][] sell = new int[n][k];
            // buy[i][j] 表示第i天时，此时持有股票，为第j次交易
            // sell[i][j] 表示第i天时，此时未持有股票，为第j次交易
            buy[0][0] = -prices[0];
            for (int i = 1; i < k; ++i) {
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }
            for (int i = 1; i < n; i++) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j < k; j++) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
                }
            }
            return Arrays.stream(sell[n-1]).max().getAsInt();
        }
    }
}
