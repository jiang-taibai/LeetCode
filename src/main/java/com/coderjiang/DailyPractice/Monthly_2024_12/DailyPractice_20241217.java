package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-17 08:42:47</p>
 */
public class DailyPractice_20241217 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minValidStrings(String[] words, String target) {
            int n = target.length();
            int[] back = new int[n];
            for (String word : words) {
                int[] next = buildNext(word, target);
                int m = word.length();
                for (int i = 0; i < n; i++) {
                    back[i] = Math.max(back[i], next[i + m + 1]);
                }
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 1 << 20);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                dp[i + 1] = dp[i + 1 - back[i]] + 1;
                if (dp[i + 1] > n) return -1;
            }
            return dp[n];
        }

        private int[] buildNext(String target, String pattern) {
            String s = target + "#" + pattern;
            int[] next = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                int j = next[i - 1];
                while (j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
                if (s.charAt(j) == s.charAt(i)) j++;
                next[i] = j;
            }
            return next;
        }
    }

}
