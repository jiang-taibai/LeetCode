package com.coderjiang.DailyPractice.Monthly_2021_11;

/**
 * <p>Creation Time: 2021-11-07 02:08:07</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_07 {

    class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int minA = m;
            int minB = n;
            for (int[] op : ops) {
                minA = Math.min(minA, op[0]);
                minB = Math.min(minB, op[1]);
            }
            return minA * minB;
        }
    }

}
