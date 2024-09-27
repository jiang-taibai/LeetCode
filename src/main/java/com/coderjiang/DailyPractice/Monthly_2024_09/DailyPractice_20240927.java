package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-27 11:25:34</p>
 */
public class DailyPractice_20240927 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0) return 0;
            int n = s.length();
            int[][] rightCnt = new int[3][k + 1];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(rightCnt[i], -1);
            }

            int a = 0, b = 0, c = 0;
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (ch == 'a' && a < k) rightCnt[0][++a] = n - i;
                else if (ch == 'b' && b < k) rightCnt[1][++b] = n - i;
                else if (ch == 'c' && c < k) rightCnt[2][++c] = n - i;
            }
            if (a < k || b < k || c < k) return -1;

            a = b = c = 0;
            int res = Math.max(rightCnt[0][k], Math.max(rightCnt[1][k], rightCnt[2][k]));
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else c++;
                int rightLen = 0;
                if (a < k) rightLen = Math.max(rightLen, rightCnt[0][k - a]);
                if (b < k) rightLen = Math.max(rightLen, rightCnt[1][k - b]);
                if (c < k) rightLen = Math.max(rightLen, rightCnt[2][k - c]);
                res = Math.min(res, (i + 1) + rightLen);
            }
            return res;
        }
    }

}
