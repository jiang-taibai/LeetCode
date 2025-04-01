package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-01 23:57:24</p>
 */
public class DailyPractice_20250401 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];
            for (int i = n - 1; i >= 0; --i) {
                int point = questions[i][0], brainpower = questions[i][1];
                if (i + questions[i][1] + 1 < n) {
                    dp[i] = Math.max(dp[i + 1], dp[i + brainpower + 1] + point);
                } else if (i + 1 < n) {
                    dp[i] = Math.max(dp[i + 1], point);
                } else {
                    dp[i] = point;
                }
            }
            return dp[0];
        }
    }

}
