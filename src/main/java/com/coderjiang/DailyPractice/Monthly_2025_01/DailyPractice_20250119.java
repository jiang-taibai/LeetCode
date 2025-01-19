package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-19 17:01:37</p>
 */
public class DailyPractice_20250119 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int MOD = (int) (1e9 + 7);
        public static final int[][] memo = new int[2][(int) (1e5 + 10)];
        public static final int[] conditions = new int[]{3, 4};

        public int countTexts(String pressedKeys) {
            char[] chars = pressedKeys.toCharArray();
            int n = chars.length;
            char ch = chars[0];
            int len = 0;
            long res = 1;
            for (int i = 0; i < n; i++) {
                if (chars[i] == ch) {
                    len++;
                } else {
                    res = (res * calCombination((ch == '7' || ch == '9') ? 1 : 0, len)) % MOD;
                    ch = chars[i];
                    len = 1;
                }
            }
            res = (res * calCombination((chars[n - 1] == '7' || chars[n - 1] == '9') ? 1 : 0, len)) % MOD;
            return (int) res;
        }

        private long calCombination(int index, int len) {
            if (len == 0) return 1;
            if (memo[index][len] != 0) return memo[index][len];
            long res = 0;
            for (int i = 1; i <= Math.min(len, conditions[index]); i++) {
                res += calCombination(index, len - i);
                res %= MOD;
            }
            memo[index][len] = (int) res;
            return res;
        }
    }

}
