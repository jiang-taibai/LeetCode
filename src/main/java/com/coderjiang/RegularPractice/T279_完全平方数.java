package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 16:26:43</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T279_完全平方数 {

    class Solution {
        public int numSquares(int n) {
            // dp[i]表示和为i的最小平方数
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; ++i) {
                int min = dp[i - 1] + 1;
                for (int j = 2; j * j <= i; ++j) {
                    min = Integer.min(min, dp[i - j * j] + 1);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

}
