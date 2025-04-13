package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-13 15:10:06</p>
 */
public class DailyPractice_20250413 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final long MOD = (long) 1e9 + 7L;

        public int countGoodNumbers(long n) {
            // 也就是计算 5 x 4 x 5 x 4 x ... (n 个)
            // 把 n 规整到偶数，那么就变成了
            // 20 x 20 x 20 x ... (n / 2 个)，剩下一个，如果 n 是奇数就再乘以 5
            // 也就是计算 20^(n/2) 的结果
            return (int) ((fastPow(20, n / 2) * (n % 2 == 0 ? 1 : 5)) % MOD);
        }

        // 快速幂：x^n
        private long fastPow(long x, long n) {
            long res = 1;
            long num = x;
            while (n != 0) {
                if (n % 2 == 0) {
                    num *= num;
                    n /= 2;
                } else {
                    res *= num;
                    n--;
                }
                res %= MOD;
                num %= MOD;
            }
            return res;
        }
    }

}
