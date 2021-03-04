package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Arrays;

/**
 * <p>创建时间：2021/3/4 16:47</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_04 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes, (int[] o1, int[] o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
            int[] dp = new int[n];
            dp[0] = 1;
            int res = 1;
            for (int i = 1; i < n; ++i) {
                dp[i] = 1;
                for (int j = 0; j < i; ++j) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
