package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-14 20:49:16</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_14 {

    class Solution {
        private boolean[][] miss;
        private boolean[] sad;
        private int res = 0;

        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            miss = new boolean[n][n];
            sad = new boolean[n];
            for (int[] pair : pairs) {
                missYou(pair[0], pair[1], preferences);
                missYou(pair[1], pair[0], preferences);
            }
            return res;
        }

        private void missYou(int x, int y, int[][] preferences) {
            for (int f : preferences[x]) {
                if (f == y) break;
                miss[x][f] = true;
                if (miss[f][x]) {
                    if (!sad[x]) res++;
                    if (!sad[f]) res++;
                    sad[x] = sad[f] = true;
                }
            }
        }

    }

}
