package com.coderjiang.DailyPractice.Monthly_2020_12;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/21 9:43
 * @description: TODO
 */
public class LeetCode_Daily_12_21 {
    public static void main(String[] args) {

    }

    static class Solution {
        /*
         * 动态规划解题
         * 第一维度：爬到第几个梯子
         * 值：爬到这梯子时的最小体力花费
         * 公式：dp[i]=min{dp[i-1]+cost[i], dp[i-2]+cost[i]}
         * */
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
            }
            return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
        }
    }
}
