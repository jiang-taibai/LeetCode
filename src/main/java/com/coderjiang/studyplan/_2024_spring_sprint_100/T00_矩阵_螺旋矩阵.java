package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-21 17:16:44</p>
 */
public class T00_矩阵_螺旋矩阵 {

    public static void main(String[] args) {

    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int VISED = -1000;
            int rows = matrix.length, cols = matrix[0].length;
            int row = 0, col = 0;
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            List<Integer> res = new ArrayList<>();
            res.add(matrix[0][0]);
            matrix[0][0] = VISED;
            while (res.size() < rows * cols) {
                for (int i = 0; i < 4; i++) {
                    int offsetRow = directions[i][0];
                    int offsetCol = directions[i][1];
                    while (row + offsetRow >= 0 && row + offsetRow < rows &&
                            col + offsetCol >= 0 && col + offsetCol < cols &&
                            matrix[row + offsetRow][col + offsetCol] != VISED) {
                        res.add(matrix[row + offsetRow][col + offsetCol]);
                        matrix[row += offsetRow][col += offsetCol] = VISED;
                    }
                }
            }
            return res;
        }
    }

}
