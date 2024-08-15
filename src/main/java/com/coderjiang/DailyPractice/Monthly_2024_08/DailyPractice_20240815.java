package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-15 09:33:32</p>
 */
public class DailyPractice_20240815 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxScore(List<List<Integer>> grid) {
            int rows = grid.size(), cols = grid.get(0).size();
            int[][] pre = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                Arrays.fill(pre[i], Integer.MAX_VALUE);
            }
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int preMin = Integer.MAX_VALUE;
                    if (i > 0) preMin = Math.min(preMin, pre[i-1][j]);
                    if (j > 0) preMin = Math.min(preMin, pre[i][j-1]);
                    if (i + j > 0) res = Math.max(res, grid.get(i).get(j) - preMin);
                    pre[i][j] = Math.min(grid.get(i).get(j), preMin);
                }
            }
            return res;
        }
    }

}
