package com.coderjiang.DailyPractice.Monthly_2021_03;

/**
 * <p>创建时间：2021/3/17 14:00</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_17 {

    // dp[i][j] 表示 s[i:] 中存在 t[j:] 子序列的个数
    // 如果s[i] == t[j],
    // 1. 匹配s[i]与t[j]，那么 dp[i][j] = dp[i + 1][j + 1];
    // 2. 不匹配s[i]与t[j]，那么 dp[i][j] = dp[i + 1][j]
    // 如果 s[i] != t[j]，那么不匹配，dp[i][j] = dp[i+1][j]
    class Solution {
        public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            if (m >= n) {
                return s.equals(t) ? 1 : 0;
            }
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                dp[i][m] = 1;
            }
            for (int i = n - 1; i >= 0; --i) {
                for (int j = m - 1; j >= 0; --j) {
                    dp[i][j] = dp[i + 1][j];
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }

}
