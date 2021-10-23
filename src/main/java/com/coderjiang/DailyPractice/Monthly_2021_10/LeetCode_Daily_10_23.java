package com.coderjiang.DailyPractice.Monthly_2021_10;

/**
 * <p>Creation Time: 2021-10-23 19:36:39</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_23 {

    class Solution {
        public int[] constructRectangle(int area) {
            int W = (int) Math.sqrt(area);
            for (int i = W; i >= 1; --i) {
                if (area % i == 0) return new int[]{area / i, i};
            }
            return null;
        }
    }

}
