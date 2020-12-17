package com.coderjiang.DailyPractice.Monthly_2020_12;


import com.coderjiang.LeetCodeUtil.TransformUtil;

import java.util.Arrays;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/17 7:58
 * @description: TODO
 * @get:
 *  1. 动态规划的第一维度是迭代的次序，第二维度是状态，第三维度也可以是状态
 */
public class LeetCode_Daily_12_17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String pricesString = "[1,3,2,8,4,9,10,7,1,4,10]";
        int res = solution.maxProfit(TransformUtil.toNumberArray(pricesString), 2);
        System.out.println(res);
    }

    static class Solution {
        // 1. 买入后发现有更便宜的，就换更便宜的买入
        // 2. 卖出应当满足 卖出后应当至少赚1元
        public int maxProfit_WRONG(int[] prices, int fee) {
            System.out.println(Arrays.toString(prices));
            int prePay = 0;
            boolean isPay = false;
            int gain = 0;
            for (int i = 0; i < prices.length; i++) {
                if (!isPay) {
                    prePay = i;
                    isPay = true;
                } else {
                    // 如果满足 1
                    if (prices[prePay] > prices[i]) {
                        prePay = i;
                    } else if (prices[i] - prices[prePay] >= fee) {
                        while (++i < prices.length && prices[i] > prices[i - 1]) {
                            System.out.println("i: " + i);
                        }
                        isPay = false;
                        gain += prices[--i] - prices[prePay] - fee;
                        System.out.println("gain: " + gain);
                    }
                }
            }
            return gain;
        }

        // 动态规划解题：
        //  1. dp[3][0] 表示第三支股票的时候不持有股票，此时可买入
        //  2. dp[3][1] 表示第三支股票的时候持有股票，此时可卖出
        //  3. dp[x][0] = max{dp[x-1][0], dp[x-1][1]+prices[x]-fee}
        //     dp[x][1] = max{dp[x-1][1], dp[x-1][0]-prices[x]};
        public int maxProfit_RIGHT_V1(int[] prices, int fee) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }

        // 动态规划优化：
        //  1. 由于每次dp[i-1][0]和dp[i-1][1]即上一次的值，不必特地开一个数组存
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int sell = 0, buy = -prices[0];
            for (int i = 1; i < n; ++i) {
                sell = Math.max(sell, buy + prices[i] - fee);
                buy = Math.max(buy, sell - prices[i]);
            }
            return Math.max(sell, buy);
        }
    }
}
