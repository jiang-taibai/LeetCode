package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-02 13:04:20</p>
 */
public class DailyPractice_20250302 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minCut(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            boolean[][] isPalindrome = new boolean[n][n];
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    if (i == j) isPalindrome[i][j] = true;
                    else if (chars[i] == chars[j] && (j == i + 1 || isPalindrome[i + 1][j - 1])) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
            int[] dp = new int[n];
            for (int i = 1; i < n; ++i) {
                int minStep = n;
                for (int j = i; j >= 0; --j) {
                    if (isPalindrome[j][i]) {
                        if (j == 0) minStep = 0;
                        else minStep = Math.min(minStep, dp[j - 1] + 1);
                    }
                }
                dp[i] = minStep;
            }
            // for(int i=0;i<n;++i) {
            //     for(int j=0;j<n;++j) {
            //         System.out.printf("%b ", isPalindrome[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println(Arrays.toString(dp));
            return dp[n - 1];
        }
    }

}
