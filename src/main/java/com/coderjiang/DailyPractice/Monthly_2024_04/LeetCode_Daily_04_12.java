package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/4/12</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_12 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findChampion(int[][] grid) {
            int n = grid.length;
            boolean[] root = new boolean[n];
            Arrays.fill(root, true);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        root[j] = false;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (root[i]) return i;
            }
            return -1;
        }
    }

}
