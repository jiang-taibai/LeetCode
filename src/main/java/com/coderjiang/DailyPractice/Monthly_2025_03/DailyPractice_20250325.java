package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-25 15:16:19</p>
 */
public class DailyPractice_20250325 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] differenceOfDistinctValues(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int[][] topLeft = new int[n][m];
            int[][] bottomRight = new int[n][m];
            int[][] answer = new int[n][m];
            final int MAX_NUM = 50;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i != 0 && j != 0) continue;
                    int row = i;
                    int col = j;
                    boolean[] vis = new boolean[MAX_NUM + 1];
                    int count = 0;
                    while (row < n && col < m) {
                        if (!vis[grid[row][col]]) {
                            vis[grid[row][col]] = true;
                            count++;
                        }
                        if (row + 1 < n && col + 1 < m) {
                            topLeft[row + 1][col + 1] = count;
                        }
                        row++;
                        col++;
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i != n - 1 && j != m - 1) continue;
                    int row = i;
                    int col = j;
                    boolean[] vis = new boolean[MAX_NUM + 1];
                    int count = 0;
                    while (row >= 0 && col >= 0) {
                        if (!vis[grid[row][col]]) {
                            vis[grid[row][col]] = true;
                            count++;
                        }
                        if (row - 1 >= 0 && col - 1 >= 0) {
                            bottomRight[row - 1][col - 1] = count;
                        }
                        row--;
                        col--;
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    answer[i][j] = Math.abs(topLeft[i][j] - bottomRight[i][j]);
                }
            }
            return answer;
        }
    }

}
