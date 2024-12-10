package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-10 08:59:41</p>
 */
public class DailyPractice_20241210 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static int[][] next = new int[][]{
                {4, 6},
                {8, 6}, {7, 9}, {4, 8},
                {3, 9, 0}, {}, {1, 7, 0},
                {2, 6}, {1, 3}, {4, 2},
        };

        public static final int MOD = (int) (1e9 + 7);

        private int[][] memo;

        public int knightDialer(int n) {
            memo = new int[10][n + 1];
            for (int i = 0; i < 10; i++) {
                Arrays.fill(memo[i], -1);
            }
            int res = 0;
            for (int i = 0; i <= 9; i++) {
                res += dfs(i, n - 1);
                res %= MOD;
            }
            return res;
        }

        public int dfs(int cur, int restStep) {
            if (memo[cur][restStep] != -1) return memo[cur][restStep];
            if (restStep == 0) return 1;
            int res = 0;
            for (int i = 0; i < next[cur].length; i++) {
                res += dfs(next[cur][i], restStep - 1);
                res %= MOD;
            }
            return memo[cur][restStep] = res;
        }

    }

}
