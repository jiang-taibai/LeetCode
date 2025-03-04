package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-04 11:01:05</p>
 */
public class DailyPractice_20250304 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean checkPartitioning(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            boolean[][] isPalindrome = new boolean[n][n];
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    if (i == j) isPalindrome[i][j] = true;
                    else if (chars[i] == chars[j] && (i == j - 1 || isPalindrome[i + 1][j - 1]))
                        isPalindrome[i][j] = true;
                }
            }
            // dp[i][j] 表示 s[0~j] 的字符串是否能分成 i 个回文串
            boolean[][] dp = new boolean[4][n];
            for (int i = 0; i < n; ++i) {
                dp[1][i] = isPalindrome[0][i];
                for (int k = 2; k <= 3; ++k) {
                    for (int j = k - 1; j <= i; ++j) {
                        if (dp[k - 1][j - 1] && isPalindrome[j][i]) {
                            dp[k][i] = true;
                            break;
                        }
                    }
                }
            }
            return dp[3][n - 1];
        }
    }

}
