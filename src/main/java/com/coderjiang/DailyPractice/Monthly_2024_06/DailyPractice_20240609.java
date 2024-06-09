package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-09 13:19:21</p>
 */
public class DailyPractice_20240609 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] val;
        private int[][] memo;

        public int maxCoins(int[] nums) {
            int n = nums.length;
            val = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = val[n + 1] = 1;
            memo = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(memo[i], -1);
            }
            return solve(0, n + 1);
        }

        private int solve(int left, int right) {
            if (left >= right - 1) return 0;
            if (memo[left][right] != -1) return memo[left][right];

            for (int i = left + 1; i < right; i++) {
                int sum = val[left] * val[i] * val[right];
                sum += solve(left, i) + solve(i, right);
                memo[left][right] = Math.max(memo[left][right], sum);
            }
            return memo[left][right];
        }
    }

}
/*
三枚硬币 a,b,c
答案是 a*b*c + a*c + max{a,c}
也就是 a*c*(b+1) + max{a,c}

如果有 5,1,4,5 四枚硬币
5,1,4 = 20
5,4,5 = 100

 */
