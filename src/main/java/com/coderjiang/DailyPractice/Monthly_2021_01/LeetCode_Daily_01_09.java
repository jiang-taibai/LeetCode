package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * 创建时间：2021/1/9 0:10 <br>
 * 主要功能：给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_09 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * <h3>解题思路</h3>
         * <ul>
         *     <others.li>
         *         确定dp数组以及下标的含义
         *         <ul>
         *             <others.li>一天中有五种状态：无操作、第一次买入、第一次卖出、第二次买入、第二次卖出</others.li>
         *             <others.li>对于dp[i][j]，i表示第i天的股票情况，j=01234，分别对应以上五种情况</others.li>
         *         </ul>
         *     </others.li>
         *     <others.li>
         *         确定递推公式
         *         <ul>
         *             <others.li>当j=1时，应当是从无操作变换而来</others.li>
         *             <others.li>当j=2时，应当是从j=1时变换而来，或者是上一支同状态的股票来的</others.li>
         *             <others.li>当j=3时，应当是从j=2时变换而来，或者是上一支同状态的股票来的</others.li>
         *             <others.li>当j=4时，应当是从j=3时变换而来，或者是上一支同状态的股票来的</others.li>
         *             <others.li>dp[i][0] = dp[i-1][0];</others.li>
         *             <others.li>dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);</others.li>
         *             <others.li>dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);</others.li>
         *             <others.li>dp[i][3] = Math.max(dp[i-1][2] - prices[i], dp[i-1][3]);</others.li>
         *             <others.li>dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);</others.li>
         *         </ul>
         *     </others.li>
         *     <others.li>
         *         dp数组如何初始化
         *         <ul>
         *             <others.li>dp[0][1] = dp[0][3] = -prices[0];</others.li>
         *         </ul>
         *     </others.li>
         *     <others.li>
         *         确定遍历顺序
         *         <ul>
         *             <others.li>从左到右遍历即可</others.li>
         *         </ul>
         *     </others.li>
         * </ul>
         */
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][5];
            dp[0][1] = dp[0][3] = -prices[0];

            for (int i = 1; i < n; ++i) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
                dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
                dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
            }
            return dp[n - 1][4];
        }
    }
}
