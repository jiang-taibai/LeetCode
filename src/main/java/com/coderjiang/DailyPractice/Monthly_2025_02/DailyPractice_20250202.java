package com.coderjiang.DailyPractice.Monthly_2025_02;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-02 19:57:40</p>
 */
public class DailyPractice_20250202 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int minA = m, minB = n;
            for (int[] op : ops) {
                minA = Math.min(minA, op[0]);
                minB = Math.min(minB, op[1]);
            }
            return minA * minB;
        }
    }

}
