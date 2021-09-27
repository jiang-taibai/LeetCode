package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-27 10:16:18</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_27 {

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            final int MOD = (int) (1e9 + 7);
            long[] dp = new long[n + 1];
            char[] chars = s.toCharArray();
            dp[0] = 1;
            for (int i = 1; i <= n; ++i) {
                int oneNum = chars[i - 1] == '*' ? 9 : (chars[i - 1] == '0'?0:1);
                dp[i] = dp[i - 1] * oneNum % MOD;
                dp[i] %= MOD;
                if(i >= 2) {
                    int twoNum = calNumberOfCombination_TwoNumber(chars[i - 2], chars[i - 1]);
                    if (twoNum == -1) return 0;
                    dp[i] += dp[i - 2] * twoNum % MOD;
                    dp[i] %= MOD;
                }
            }
            return (int)dp[n];
        }

        // *16
        // * 16
        // *1 6
/*
pre: 1 2 3 4 5 6 7 8 9
cur: 1 2 3 4 5 6 7 8 9

*6: 16 26 36 46 56 66 76 86 96
*7: 17 27 37 47 57 67 77 87 97
0*: 01 02 03 04 05 06 07 08 09
1*: 11 12 13 14 15 16 17 18 19
2*: 21 22 23 24 25 26
*0: 10 20 30 40 50 60 70 80 90
3*: 31 32 33 34 35 36 37 38 39
 */
        private int calNumberOfCombination_TwoNumber(char pre, char cur) {
            if (pre == '*' && cur == '*') {
                return 15;
            }
            if (pre == '*') {
                return cur <= '6' ? 2 : 1;
            }
            if (cur == '*') {
                if (pre == '1') {
                    return 9;
                }
                if (pre == '2') {
                    return 6;
                }
                return 0;
            }
            return (pre != '0' && (pre - '0') * 10 + (cur - '0') <= 26) ? 1 : 0;
        }
    }
}
