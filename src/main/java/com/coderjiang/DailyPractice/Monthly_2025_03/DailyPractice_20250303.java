package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-03 11:29:14</p>
 */
public class DailyPractice_20250303 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int palindromePartition(String s, int k) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int[][] toPalindrome = new int[n][n];
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    if (i == j) continue;
                    toPalindrome[i][j] = chars[i] == chars[j] ? 0 : 1;
                    if (i != j - 1) toPalindrome[i][j] += toPalindrome[i + 1][j - 1];
                }
            }
            // for(int i=0;i<n;++i) {
            //     for(int j=0;j<n;++j) {
            //         if(j<i) System.out.printf("  ");
            //         else System.out.printf("%d ", toPalindrome[i][j]);
            //     }
            //     System.out.println();
            // }
            if (k == 1) return toPalindrome[0][n - 1];
            // dp[i][j] 表示将 s[0~j] 的字符串分割为 i 个回文串，所需最少修改字符数
            int[][] dp = new int[k + 1][n];
            for (int i = 0; i < n; ++i) {
                dp[1][i] = toPalindrome[0][i];
                for (int k1 = 2; k1 <= k; ++k1) {
                    dp[k1][i] = n;
                    for (int j = i; j >= k1 - 1; --j) {
                        dp[k1][i] = Math.min(dp[k1][i], dp[k1 - 1][j - 1] + toPalindrome[j][i]);
                    }
                }
            }
            return dp[k][n - 1];
        }
    }

}
