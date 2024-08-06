package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-06 11:49:17</p>
 */
public class DailyPractice_20240806 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int[][][][] memo;
        final long MOD = (long) (1e9 + 7);

        public int numberOfStableArrays(int zero, int one, int limit) {
            memo = new int[2][zero + 1][one + 1][limit + 1];
            for (int p = 0; p < 2; p++) {
                for (int z = 0; z < zero + 1; z++) {
                    for (int o = 0; o < one + 1; o++) {
                        Arrays.fill(memo[p][z][o], -1);
                    }
                }
            }
            return (int) dfs(zero, one, 0, 0, limit);
        }

        private long dfs(int zero, int one, int consecutive, int preNumber, int limit) {
            if (zero == 0 && one == 0) return 1;
            if (zero < 0 || one < 0) return 0;
            if (memo[preNumber][zero][one][consecutive] != -1) return memo[preNumber][zero][one][consecutive];
            long res = 0;
            if (preNumber == 0) {
                if (consecutive < limit) {
                    res += dfs(zero - 1, one, consecutive + 1, 0, limit) % MOD;
                }
                res += dfs(zero, one - 1, 1, 1, limit) % MOD;
            } else {
                if (consecutive < limit) {
                    res += dfs(zero, one - 1, consecutive + 1, 1, limit) % MOD;
                }
                res += dfs(zero - 1, one, 1, 0, limit) % MOD;
            }
            res %= MOD;
            memo[preNumber][zero][one][consecutive] = (int) res;
            return res;
        }
    }

}
