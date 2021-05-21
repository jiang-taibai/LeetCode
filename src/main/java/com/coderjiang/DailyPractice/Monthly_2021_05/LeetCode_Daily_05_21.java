package com.coderjiang.DailyPractice.Monthly_2021_05;

/**
 * <p>创建时间：2021/5/21 10:52</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_21 {

    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = n - 1; i >= 0; i--) {
                int num1 = nums1[i];
                for (int j = m - 1; j >= 0; j--) {
                    int num2 = nums2[j];
                    if (num1 == num2) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[0][0];
        }
    }

}
