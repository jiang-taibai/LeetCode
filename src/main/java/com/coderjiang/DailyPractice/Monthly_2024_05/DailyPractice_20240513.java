package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-13 00:35:38</p>
 */
public class DailyPractice_20240513 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int orangesRotting(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int numOfOranges = 0;
            Queue<Integer> cur = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) numOfOranges++;
                    else if (grid[i][j] == 2) {
                        cur.add(i * 100 + j);
                    }
                }
            }
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int minus = 0;
            while (!cur.isEmpty() && numOfOranges > 0) {
                Queue<Integer> next = new LinkedList<>();
                while (!cur.isEmpty()) {
                    int pos = cur.poll();
                    int row = pos / 100;
                    int col = pos % 100;
                    for (int[] direction : directions) {
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                            continue;
                        }
                        if (grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            numOfOranges--;
                            next.add(newRow * 100 + newCol);
                        }
                    }
                }
                minus++;
                cur = next;
            }
            return numOfOranges == 0 ? minus : -1;
        }
    }

}
