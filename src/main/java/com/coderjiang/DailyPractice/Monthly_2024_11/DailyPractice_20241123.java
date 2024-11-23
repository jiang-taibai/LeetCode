package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-23 11:26:50</p>
 */
public class DailyPractice_20241123 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int winningPlayerCount(int n, int[][] pick) {
            int[][] cnt = new int[n][11];
            for (int[] p : pick) {
                int x = p[0], y = p[1];
                ++cnt[x][y];
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= 10; j++) {
                    if(cnt[i][j] > i) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }

}
