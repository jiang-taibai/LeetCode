package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2024/3/22</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_22 {

    public static void main(String[] args) {
    }

    static class Solution_MY {

        int rows, cols;
        int[][] memo;

        public int minimumVisitedCells(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            memo = new int[rows][cols];
            dfs(grid, 0, 0);
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    System.out.printf("%d ", memo[i][j]);
//                }
//                System.out.println();
//            }
            return memo[0][0];
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i == rows - 1 && j == cols - 1) return 1;
            if (memo[i][j] != 0) return memo[i][j];
            int minStep = Integer.MAX_VALUE;
            for (int k = j + 1; k <= Integer.min(j + grid[i][j], cols - 1); k++) {
                int subStep = dfs(grid, i, k);
                if (subStep != -1) {
                    minStep = Integer.min(minStep, subStep);
                }
            }
            for (int k = i + 1; k <= Integer.min(i + grid[i][j], rows - 1); k++) {
                int subStep = dfs(grid, k, j);
                if (subStep != -1) {
                    minStep = Integer.min(minStep, subStep);
                }
            }
            if (minStep == Integer.MAX_VALUE) {
                return memo[i][j] = -1;
            } else {
                return memo[i][j] = minStep + 1;
            }
        }
    }

    static class Solution {
        public int minimumVisitedCells(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; ++i) {
                Arrays.fill(dist[i], -1);
            }
            dist[0][0] = 1;
            PriorityQueue<int[]>[] row = new PriorityQueue[m];
            PriorityQueue<int[]>[] col = new PriorityQueue[n];
            for (int i = 0; i < m; ++i) {
                row[i] = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            }
            for (int i = 0; i < n; ++i) {
                col[i] = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j) {
                        row[i].poll();
                    }
                    if (!row[i].isEmpty()) {
                        dist[i][j] = update(dist[i][j], dist[i][row[i].peek()[1]] + 1);
                    }

                    while (!col[j].isEmpty() && col[j].peek()[1] + grid[col[j].peek()[1]][j] < i) {
                        col[j].poll();
                    }
                    if (!col[j].isEmpty()) {
                        dist[i][j] = update(dist[i][j], dist[col[j].peek()[1]][j] + 1);
                    }

                    if (dist[i][j] != -1) {
                        row[i].offer(new int[]{dist[i][j], j});
                        col[j].offer(new int[]{dist[i][j], i});
                    }
                }
            }

            return dist[m - 1][n - 1];
        }

        public int update(int x, int y) {
            return x == -1 || y < x ? y : x;
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/solutions/2693762/wang-ge-tu-zhong-zui-shao-fang-wen-de-ge-944f/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}