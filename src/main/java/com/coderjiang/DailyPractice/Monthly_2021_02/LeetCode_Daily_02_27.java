package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/27 19:45</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_27 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestSubstring(String s, int k) {
            int n = s.length();
            return dfs(s, 0, n - 1, k);
        }

        private int dfs(String s, int lhs, int rhs, int k) {
            int[] count = new int[26];
            for (int i = lhs; i <= rhs; ++i) {
                count[s.charAt(i) - 'a']++;
            }

            char splitChar = 0;
            for (int i = 0; i < 26; ++i) {
                if (count[i] > 0 && count[i] < k) {
                    splitChar = (char) (i + 'a');
                    break;
                }
            }

            if (splitChar == 0) {
                return rhs - lhs + 1;
            }

            int i = lhs;
            int res = 0;
            while (i <= rhs) {
                while (i <= rhs && s.charAt(i) == splitChar) {
                    i++;
                }
                if (i > rhs) {
                    break;
                }
                int start = i;
                while (i <= rhs && s.charAt(i) != splitChar) {
                    i++;
                }
                int length = dfs(s, start, i - 1, k);
                res = Math.max(res, length);
            }
            return res;
        }
    }
}
