package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>创建时间：2021/3/7 18:03</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_07 {
    public static void main(String[] args) {

    }

    class Solution {
        private boolean[][] dp;
        private List<String> ans = new ArrayList<>();
        private List<List<String>> res = new ArrayList<>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            dp = new boolean[n][n];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], true);
            }
            // i=j-> dp[i][j] = true;
            // i<j-> dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j))
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
            dfs(s, 0);
            return res;
        }

        private void dfs(String s, int start) {
            if (start == n) {
                res.add(new ArrayList<>(ans));
            }
            for (int i = start; i < n; ++i) {
                if (dp[start][i]) {
                    ans.add(s.substring(start, i + 1));
                    dfs(s, i + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
}
