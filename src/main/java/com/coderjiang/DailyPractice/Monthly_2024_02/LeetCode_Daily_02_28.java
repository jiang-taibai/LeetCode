package com.coderjiang.DailyPractice.Monthly_2024_02;

/**
 * <p>Creation Time: 2024/2/28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_28 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minIncrements(int n, int[] cost) {
            return dfs(n, cost, 1)[1];
        }

        private int[] dfs(int n, int[] cost, int root) {
            if (root <= n) {
                int[] left = dfs(n, cost, root * 2);
                int[] right = dfs(n, cost, root * 2 + 1);
                return new int[]{
                        Math.max(left[0], right[0]) + cost[root - 1],
                        Math.abs(left[0] - right[0]) + left[1] + right[1]
                };
            }
            return new int[]{0, 0};
        }
    }

}
