package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-07 11:37:45</p>
 */
public class DailyPractice_20240807 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        static final int MOD = 1000000007;
        static final int ONE = 1;
        static final int ZERO = 0;

        int[][][] memo;
        int limit;

        public int numberOfStableArrays(int zero, int one, int limit) {
            this.limit = limit;
            this.memo = new int[zero + 1][one + 1][2];
            for (int i = 0; i < this.memo.length; i++) {
                for (int j = 0; j < this.memo[i].length; j++) {
                    this.memo[i][j][0] = this.memo[i][j][1] = -1;
                }
            }
            return (dfs(zero, one, 0) + dfs(zero, one, 1)) % MOD;
        }

        private int dfs(int zero, int one, int lastNum) {
            if (zero == 0) {
                return (lastNum == ZERO || one > limit) ? 0 : 1;
            } else if (one == 0) {
                return (lastNum == ONE || zero > limit) ? 0 : 1;
            }
            if (memo[zero][one][lastNum] != -1) return memo[zero][one][lastNum];
            int res = 0;
            if (lastNum == ZERO) {
                res += (dfs(zero - 1, one, ZERO) + dfs(zero - 1, one, ONE)) % MOD;
                if (zero > limit)
                    res = (res - dfs(zero - 1 - limit, one, ONE) + MOD) % MOD;
            } else {
                res += (dfs(zero, one - 1, ZERO) + dfs(zero, one - 1, ONE)) % MOD;
                if (one > limit)
                    res = (res - dfs(zero, one - 1 - limit, ZERO) + MOD) % MOD;
            }
            memo[zero][one][lastNum] = res % MOD;
            return memo[zero][one][lastNum];
        }
    }

}
