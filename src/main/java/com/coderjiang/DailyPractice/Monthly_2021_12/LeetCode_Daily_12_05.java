package com.coderjiang.DailyPractice.Monthly_2021_12;

/**
 * <p>Creation Time: 2021-12-05 09:23:32</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_05 {

    class Solution {

        private final int MOD = 1337;

        public int superPow(int a, int[] b) {
            if (b.length == 1 && b[0] == 0) return 1;
            return dfs(a, b, b.length - 1);
        }

        private int dfs(int a, int[] b, int u) {
            if (u < 0) return 1;
            return (pow(dfs(a, b, u - 1), 10) % MOD) * (pow(a, b[u]) % MOD) % MOD;
        }

        private int pow(int a, int b) {
            int res = 1;
            a %= MOD;
            for (int i = 1; i <= b; ++i) {
                res *= a;
                res %= MOD;
            }
            return res;
        }
    }
}
