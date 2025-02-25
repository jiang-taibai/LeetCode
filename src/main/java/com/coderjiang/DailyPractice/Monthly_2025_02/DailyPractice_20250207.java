package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-07 21:51:25</p>
 */
public class DailyPractice_20250207 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int count = 0;
            int directionIndex = 0;
            int x = 0, y = -1;
            while (count < n * n) {
                int diffX = directions[directionIndex][0];
                int diffY = directions[directionIndex][1];
                int newX = x + diffX, newY = y + diffY;
                while (newX >= 0 && newY >= 0 && newX < n && newY < n && res[newX][newY] == 0) {
                    res[newX][newY] = count + 1;
                    x = newX;
                    y = newY;
                    newX += diffX;
                    newY += diffY;
                    count++;
                }
                directionIndex = (directionIndex + 1) % 4;
            }
            return res;
        }
    }

}
