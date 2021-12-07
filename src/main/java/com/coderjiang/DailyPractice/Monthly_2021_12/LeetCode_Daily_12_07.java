package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Creation Time: 2021-12-07 23:46:12</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_07 {

    class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int n = grid.length;
            int m = grid[0].length;
            int originColor = grid[row][col];

            Queue<Point> que = new LinkedList<>();
            que.add(new Point(row, col));
            boolean[][] vis = new boolean[n][m];
            vis[row][col] = true;

            int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            while (que.size() != 0) {
                Point point = que.poll();
                grid[point.x][point.y] = color;
                for (int[] offset : offsets) {
                    int newx = point.x + offset[0];
                    int newy = point.y + offset[1];
                    if (newx >= 0 && newy >= 0 && newx < n && newy < n
                            && grid[newx][newy] == originColor
                            && !vis[newx][newy]) {
                        que.add(new Point(newx, newy));
                    }
                }
            }
            return grid;
        }

        class Point {

            int x, y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }
    }

}
