package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024-02-02</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_02 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] aliceValues = {1, 3};
        int[] bobValues = {2, 1};
        System.out.println(solution.stoneGameVI(aliceValues, bobValues));
    }

    static class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int n = aliceValues.length;
            // 对于 i, j 两个石头
            // alice 认为的价值为 ai, aj
            // bob 认为的价值为 bi, bj
            // 如果先手选 i，那么分数差为 ai-bj
            // 如果先手选 j，那么分数差为 aj-bi
            // 那么先手选 i,j 取决于分数差最大的
            // δ=(ai-bj)-(aj-bi)=(ai+bi)-(aj+bj)
            // 如果 δ>=0 那么先手选 i，如果 δ<0 那么先手选 j
            // 即先手想赢，就应该选 ax+bx 最大的石头
            int[][] values = new int[n][3];
            for (int i = 0; i < n; i++) {
                values[i][0] = aliceValues[i] + bobValues[i];
                values[i][1] = aliceValues[i];
                values[i][2] = bobValues[i];
            }
            Arrays.sort(values, (lhs, rhs) -> rhs[0] - lhs[0]);
            int alice = 0, bob = 0;
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 2 == 0) {
                    bob += values[i][2];
                } else {
                    alice += values[i][1];
                }
            }
            if (alice > bob) {
                return 1;
            } else if (alice < bob) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
