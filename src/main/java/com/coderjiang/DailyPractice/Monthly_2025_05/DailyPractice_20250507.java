package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-07 13:05:44</p>
 */
public class DailyPractice_20250507 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minTimeToReach(int[][] moveTime) {
            int rows = moveTime.length, cols = moveTime[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            pq.offer(new int[]{0, 0});
            boolean[][] vis = new boolean[rows][cols];
            vis[0][0] = true;
            int[][] directions = new int[][]{
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0}
            };
            while (!pq.isEmpty()) {
                int[] point = pq.poll();
                int time = point[0], row = point[1] / cols, col = point[1] % cols;
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || vis[newRow][newCol]) continue;
                    int enterTime = Math.max(time + 1, moveTime[newRow][newCol] + 1);
                    if (newRow == rows - 1 && newCol == cols - 1) return enterTime;
                    pq.offer(new int[]{enterTime, newRow * cols + newCol});
                    vis[newRow][newCol] = true;
                }
            }
            return -1;
        }
    }

}
