package com.coderjiang.DailyPractice.Monthly_2024_02;


import java.util.Arrays;

/**
 * <p>Creation Time: 2024-02-03</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_03 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int[] preSum;
        int[][] memo;

        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + stones[i - 1];
            }
            memo = new int[n][n];
            for (int[] arr : memo) {
                Arrays.fill(arr, -1);
            }
            return dfs(stones, 0, n - 1);
        }

        private int dfs(int[] stones, int l, int r) {
            if (l > r) return 0;
            if (memo[l][r] != -1) return memo[l][r];
            int peakLeft = sum(l + 1, r) - dfs(stones, l + 1, r);
            int peakRight = sum(l, r - 1) - dfs(stones, l, r - 1);
            int res = Math.max(peakLeft, peakRight);
            memo[l][r] = res;
            return res;
        }

        private int sum(int l, int r) {
            return preSum[r + 1] - preSum[l];
        }
    }

}
