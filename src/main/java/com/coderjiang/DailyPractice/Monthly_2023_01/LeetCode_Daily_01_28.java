package com.coderjiang.DailyPractice.Monthly_2023_01;

import java.util.Arrays;

/**
 * <p>Creation Time: 2023-01-28 00:12:56</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_28 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] tests = {
                {2, 1, 6, 4},
                {1, 1, 1},
                {1, 2, 3},
        };
        int[] expects = {
                1,
                3,
                0,
        };
        for (int i = 0; i < tests.length; ++i) {
            int res = solution.waysToMakeFair(tests[i]);
            System.out.printf("Args=%s\nOutput=%d\nExpect=%d\n================\n", Arrays.toString(tests[i]), res, expects[i]);
        }
    }

    static class Solution {
        public int waysToMakeFair(int[] nums) {
            int n = nums.length;
            int[] oddSum = new int[n + 1];      // 奇之和，oddSum[i]表示nums[i->n]之间的所有奇数坐标之和
            int[] evenSum = new int[n + 1];     // 偶之和，evenSum[i]表示nums[i->n]之间所有偶数坐标之和
            for (int i = n - 1; i >= 0; --i) {
                if ((i & 1) == 0) {
                    // 如果当前坐标是偶数
                    evenSum[i] = nums[i] + evenSum[i + 1];
                    oddSum[i] = oddSum[i + 1];
                } else {
                    evenSum[i] = evenSum[i + 1];
                    oddSum[i] = nums[i] + oddSum[i + 1];
                }
            }
            int count = 0;
            for (int i = 0; i < n; ++i) {
                int preOddSum = oddSum[0] - oddSum[i];
                int preEvenSum = evenSum[0] - evenSum[i];
                int postOddSum = evenSum[i + 1];
                int postEvenSum = oddSum[i + 1];
                if (preOddSum + postOddSum == preEvenSum + postEvenSum) count++;
            }
            return count;
        }
    }

}
