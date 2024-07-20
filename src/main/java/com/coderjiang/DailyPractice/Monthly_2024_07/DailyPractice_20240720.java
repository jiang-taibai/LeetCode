package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-20 13:09:44</p>
 */
public class DailyPractice_20240720 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumMoves(int[][] grid) {
            List<int[]> zeros = new ArrayList<>();
            List<int[]> fulls = new ArrayList<>();
            int n = 3;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) zeros.add(new int[]{i, j});
                    else if (grid[i][j] > 1) fulls.add(new int[]{i, j});
                }
            }
            return dfs(grid, zeros, fulls, 0);
        }

        private int dfs(int[][] grid, List<int[]> zeros, List<int[]> fulls, int zeroIndex) {
            if (zeroIndex >= zeros.size()) return 0;
            int res = Integer.MAX_VALUE;
            int[] p1 = zeros.get(zeroIndex);
            for (int[] p2 : fulls) {
                if (grid[p2[0]][p2[1]] > 1) {
                    grid[p2[0]][p2[1]]--;
                    res = Math.min(res, manhattanDistance(p1, p2) + dfs(grid, zeros, fulls, zeroIndex + 1));
                    grid[p2[0]][p2[1]]++;
                }
            }
            return res;
        }

        private int manhattanDistance(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

    }

}

/*
[
[3,2,0],
[0,1,0],
[0,3,0]]
[
[0,2,3],
[2,0,1],
[0,1,0]]
(0,0), (1,1), (2,0), (2,2)
(0,1), (0,2), (1,0)
 */
