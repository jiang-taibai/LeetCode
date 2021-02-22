package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/22 12:05</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_22 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int i = 0; i < cols; ++i) {
                int num = matrix[0][i];
                for (int j = 1; i + j < cols && j < rows; ++j) {
                    if (matrix[j][i + j] != num) return false;
                }
            }
            for (int i = 0; i < rows; ++i) {
                int num = matrix[i][0];
                for (int j = 1; i + j < rows && j < cols; ++j) {
                    if (matrix[i + j][j] != num) return false;
                }
            }
            return true;
        }
    }
}
