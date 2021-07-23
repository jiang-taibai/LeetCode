package com.coderjiang.DailyPractice.Monthly_2021_07;

/**
 * <p>Creation Time: 2021-07-23 09:21:35</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_23 {

    class Solution {

        public static final int MAXSIZE = 50 + 10;

        public boolean isCovered(int[][] ranges, int left, int right) {
            boolean[] vis = new boolean[MAXSIZE];
            for (int[] range : ranges) {
                for (int i = range[0]; i <= range[1]; i++) {
                    vis[i] = true;
                }
            }
            for (int i = left; i <= right; i++) {
                if(!vis[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
