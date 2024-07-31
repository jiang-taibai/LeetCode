package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-31 10:33:37</p>
 */
public class DailyPractice_20240731 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minRectanglesToCoverPoints(int[][] points, int w) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int keyBound = -1;
            int res = 0;
            for (int[] point : points) {
                if (point[0] > keyBound) {
                    res++;
                    keyBound = point[0] + w;
                }
            }
            return res;
        }
    }

}
