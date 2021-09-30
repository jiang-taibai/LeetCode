package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-09-30 00:15:05</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_30 {

    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            if (ax2 < bx1 || ax1 > bx2 || ay1 > by2 || ay2 < by1) return 0;
            int[] x = new int[]{ax1, ax2, bx1, bx2};
            int[] y = new int[]{ay1, ay2, by1, by2};
            Arrays.sort(x);
            Arrays.sort(y);
            System.out.println(Arrays.toString(x));
            System.out.println(Arrays.toString(y));
            return (x[2] - x[1]) * (y[2] - y[1]);
        }
    }

}
