package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-05 21:28:13</p>
 */
public class DailyPractice_20240805 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int findIntegers(int n) {
            long[][] dp = getSeqCount();
            char[] binaries = Integer.toBinaryString(n).toCharArray();
            long res = valid(n) ? 1 : 0;
            int len = binaries.length;
            for (int i = 0; i < len; i++) {
                if (i >= 2 && binaries[i - 1] == '1' && binaries[i - 2] == '1') break;
                if (binaries[i] == '1') {
                    res += dp[len - i - 1][0] + dp[len - i - 1][1];
                }
            }
            return (int) res;
        }

        private long[][] getSeqCount() {
            long[][] dp = new long[33][2];
            dp[0][0] = 1;
            for (int i = 1; i < 33; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }
            return dp;
        }

        private boolean valid(int n) {
            while (n != 0) {
                if ((n & 1) == 1 && ((n >> 1) & 1) == 1) return false;
                n >>= 1;
            }
            return true;
        }
    }

}
/*
如果有一个二进制为
101010110

那么化解成小问题
101010110
0********
100******
10100****
1010100**
10101010*
*代表可以填0或1，且不能连续，那么有多少种可能？
这就是动态规划了

101
0**
100

 */
