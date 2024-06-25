package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-26 05:45:16</p>
 */
public class DailyPractice_20240626 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int n;
        boolean[][] matrix;
        int[][] memo;
        final int MOD = (int) (1e9 + 7);

        public int specialPerm(int[] nums) {
            n = nums.length;
            matrix = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nums[i] % nums[j] == 0) {
                        matrix[i][j] = matrix[j][i] = true;
                    }
                }
            }
            memo = new int[n][1 << n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            int count = 0;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                vis[i] = true;
                count += dfs(vis, 1, i) % MOD;
                count %= MOD;
                vis[i] = false;
            }
            return count;
        }

        private int dfs(boolean[] vis, int vised, int cur) {
            if (vised == n) return 1;
            int hashCode = hash(vis);
            if (memo[cur][hashCode] != -1) {
                return memo[cur][hashCode];
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && matrix[cur][i]) {
                    vis[i] = true;
                    count += dfs(vis, vised + 1, i) % MOD;
                    count %= MOD;
                    vis[i] = false;
                }
            }
            return memo[cur][hashCode] = count;
        }

        private int hash(boolean[] arr) {
            int res = 0;
            for (boolean b : arr) {
                res <<= 1;
                res += b ? 1 : 0;
            }
            return res;
        }
    }

}

/*
2,3,6
可以组成图
2--6
   |
   3
这就要求可以把它拉成一条直线的方法
那如果是
3,9,27,6
6-3-9-27
  |----|
那么就意味着有一个环
可以是
6,3,9,27
6,3,27,9
 */
