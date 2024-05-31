package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-31 22:45:39</p>
 */
public class DailyPractice_20240531 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            boolean[] vis = new boolean[n * n + 1];
            vis[0] = true;
            int a = -1, b = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = grid[i][j];
                    if (vis[num]) {
                        a = num;
                    } else {
                        vis[num] = true;
                    }
                }
            }
            for (int i = 0; i < vis.length; i++) {
                if (!vis[i]) {
                    b = i;
                    break;
                }
            }
            return new int[]{a, b};
        }
    }

}
