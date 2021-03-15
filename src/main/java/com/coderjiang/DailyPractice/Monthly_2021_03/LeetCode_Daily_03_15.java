package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>创建时间：2021/3/15 13:08</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_15 {
    public static void main(String[] args) {

    }

    class Solution {

        public final Integer INVALID = 200;
        private Integer rows;
        private Integer cols;

        public List<Integer> spiralOrder(int[][] matrix) {
            int count = 0;
            rows = matrix.length;
            cols = matrix[0].length;
            int circle = 0;
            List<Integer> res = new LinkedList<>();
            while (count < rows * cols) {
                int i = circle, j = circle;
                while (true) {
                    // System.out.println("(i, j) = (" + i + ", " + j + ")");
                    if (isValid(i, j, matrix)) {
                        res.add(matrix[i][j]);
                        count++;
                        matrix[i][j] = INVALID;
                        j++;
                    } else {
                        j--;
                        i++;
                        break;
                    }
                }

                while (true) {
                    // System.out.println("(i, j) = (" + i + ", " + j + ")");
                    if (isValid(i, j, matrix)) {
                        res.add(matrix[i][j]);
                        count++;
                        matrix[i][j] = INVALID;
                        i++;
                    } else {
                        i--;
                        j--;
                        break;
                    }
                }

                while (true) {
                    // System.out.println("(i, j) = (" + i + ", " + j + ")");
                    if (isValid(i, j, matrix)) {
                        res.add(matrix[i][j]);
                        count++;
                        matrix[i][j] = INVALID;
                        j--;
                    } else {
                        j++;
                        i--;
                        break;
                    }
                }

                while (true) {
                    // System.out.println("(i, j) = (" + i + ", " + j + ")");
                    if (isValid(i, j, matrix)) {
                        res.add(matrix[i][j]);
                        count++;
                        matrix[i][j] = INVALID;
                        i--;
                    } else {
                        ++i;
                        break;
                    }
                }
                circle++;
            }
            return res;
        }

        private boolean isValid(int i, int j, int[][] matrix) {
            return i < rows && j < cols && i >= 0 && j >= 0 && matrix[i][j] != INVALID;
        }
    }
}
