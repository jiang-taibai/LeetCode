package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-22 10:02:17</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_22 {

    class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int distance = manhattanDistance(new int[]{0, 0}, target);
            for (int[] ghost : ghosts) {
                if(manhattanDistance(ghost, target) <= distance) {
                    return false;
                }
            }
            return true;
        }

        private int manhattanDistance(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }
    }

}
