package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-21 11:42:31</p>
 */
public class DailyPractice_20240721 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximumSum(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][2];
            dp[0][0] = arr[0];
            dp[0][1] = 0;
            int res = arr[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = max(dp[i - 1][0], 0) + arr[i];
                dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
                res = max(res, max(dp[i][0], dp[i][1]));
            }
            return res;
        }

        private int max(int a, int b) {
            return Math.max(a, b);
        }
    }

}
