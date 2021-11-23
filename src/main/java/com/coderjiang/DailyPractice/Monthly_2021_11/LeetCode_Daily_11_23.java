package com.coderjiang.DailyPractice.Monthly_2021_11;

/**
 * <p>Creation Time: 2021-11-23 00:05:56</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_23 {

    class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) return false;
            char[] s_char = s.toCharArray();
            char[] goal_char = goal.toCharArray();
            int[] counts = new int[26];
            boolean flag = false;
            int n = s_char.length;
            int cnt = 0;
            int first = -1, second = -1;
            for (int i = 0; i < n; ++i) {
                if (s_char[i] != goal_char[i]) {
                    if (++cnt >= 3) return false;
                    if (first == -1) first = i;
                    else second = i;
                }
                if (++counts[s_char[i] - 'a'] >= 2) {
                    flag = true;
                }
            }
            if (cnt == 0) {
                return flag;
            }
            return cnt == 2 && s_char[first] == goal_char[second] && goal_char[first] == s_char[second];
        }
    }

}
