package com.coderjiang.DailyPractice.Monthly_2024_04;


/**
 * <p>Creation Time: 2024/4/19</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_19 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private static final double INF = 1e20;
        private static final double EPS = 1e-7;

        public int minSkips(int[] dist, int speed, int hoursBefore) {
            int n = dist.length;
            // dp[i][j]表示从dist[0]到dist[i-1]跳过了j次的最短用时
            double[][] dp = new double[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = INF;
                }
            }
            dp[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j != i) {
                        // 没跳过
                        dp[i][j] = Math.min(dp[i][j], Math.ceil(dp[i - 1][j] + (double) dist[i - 1] / speed - EPS));
                    }
                    if (j != 0) {
                        // 跳过了
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (double) dist[i - 1] / speed);
                    }
                }
            }
            for (int j = 0; j <= n; j++) {
                if (dp[n][j] < hoursBefore + EPS) return j;
            }
            return -1;
        }
    }

}
/*
[1,3,2], 4
[(1,3), (3,1), (2,0)]

[1,2,2], 4
[(1,3), (2,2), (2,0)]
跳过一次
[(1,0), (2,2), (2,0)]
[(3,2), (2,0)]

对于
[1,1,1,2,2], 4
合并[1,1,2]会抵消第三个的休息时间
合并[1,1,1]不会抵消休息时间

逆向思维
[(1,1,)]
 */
