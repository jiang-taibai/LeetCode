package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-24 20:16:59</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_24 {

    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int count = 0;
                for (int j = 0; j < points.length; ++j) {
                    if (calDistance(queries[i][0], queries[i][1], points[j][0], points[j][1]) <= queries[i][2]) count++;
                }
                res[i] = count;
            }
            return res;
        }

        private double calDistance(int x1, int y1, int x2, int y2) {
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
    }

}
