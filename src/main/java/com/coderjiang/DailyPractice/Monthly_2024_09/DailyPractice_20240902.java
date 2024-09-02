package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-02 12:12:51</p>
 */
public class DailyPractice_20240902 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final char T = 'T';
        public static final char F = 'F';
        public static int foo = 0;

        public int maxConsecutiveAnswers(String answerKey, int k) {
            char[] chars = answerKey.toCharArray();
            int n = chars.length;
            int t = 0, f = 0;
            int l = 0, r = k - 1;
            int res = k;

            for (int i = 0; i <= r; i++) foo = chars[r] == T ? t++ : f++;
            while (r + 1 < n) {
                r++;
                foo = chars[r] == T ? t++ : f++;
                while (Math.min(t, f) > k) {
                    foo = chars[l] == T ? t-- : f--;
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }

            return res;
        }
    }

}
