package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-16 11:45:57</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_16 {

    class Solution {
        public int countArrangement(int n) {
            int[] dp = new int[1 << n];
            dp[0] = 1;
            for (int i = 1; i < (1 << n); ++i) {
                int count = Integer.bitCount(i);
                for (int j = 0; j < n; ++j) {
                    if ((i & (1 << j)) != 0 && (count % (j + 1) == 0 || (j + 1) % count == 0)) {
                        dp[i] += dp[i ^ (1 << j)];  // 去掉第i个
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }

}
