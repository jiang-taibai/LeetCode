package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-05 14:52:46</p>
 */
public class DailyPractice_20240705 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            int[] maxOfCol = new int[cols];
            Arrays.fill(maxOfCol, -1);
            for (int j = 0; j < cols; j++) {
                for (int[] ints : matrix) {
                    maxOfCol[j] = Math.max(maxOfCol[j], ints[j]);
                }
                for (int i = 0; i < rows; i++) {
                    if (matrix[i][j] == -1) matrix[i][j] = maxOfCol[j];
                }
            }
            return matrix;
        }
    }

}
