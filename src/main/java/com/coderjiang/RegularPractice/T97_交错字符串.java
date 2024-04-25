package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 17:24:37</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T97_交错字符串 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }

    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
            if (n1 + n2 != n3) return false;
            // dp[i][j]为true时表示【s1前i个字符】和【s2前j个字符】可以交错成为【s3前i+j个字符】
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            for (int i = 0; i <= n1; ++i) {
                for (int j = 0; j <= n2; ++j) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (i > 0) {
                        dp[i][j] = dp[i][j] || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
                    }
                    System.out.printf("dp[%d][%d]=%s\t", i, j, dp[i][j]);
                }
                System.out.println();
            }
            return dp[n1][n2];
        }
    }

}
