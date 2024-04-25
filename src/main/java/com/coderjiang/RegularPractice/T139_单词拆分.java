package com.coderjiang.RegularPractice;

import java.util.HashSet;
import java.util.List;

/**
 * <p>Creation Time: 2023-03-14 05:42:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T139_单词拆分 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            // dp[i]表示以第i个字符（从1开始）结尾的字符串是否可以由wordDict拼成
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            // 将wordDict转成HashSet提高效率
            HashSet<String> dict = new HashSet<>(wordDict);
            for (int i = 1; i <= n; ++i) {
                if (!dp[i - 1]) continue;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 20; ++j) {
                    if (i + j - 1 >= n) break;
                    sb.append(s.charAt(i + j - 1));
                    // 如果已经成立了，就不需要判断了
                    if (dp[i + j]) continue;
                    if (dict.contains(sb.toString())) dp[i + j] = true;
                }
            }
            for (int i = 0; i <= n; ++i) {
                System.out.printf("dp[%d]: %s\t", i, dp[i]);
            }
            return dp[n];
        }
    }
}
