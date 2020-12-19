package com.coderjiang.DailyPractice.Monthly_2020_12;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/19 9:36
 * @description: 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 */
public class LeetCode_Daily_12_19 {
    public static void main(String[] args) {

    }

    /*
     * 先对角反转，再镜像翻转
     * */
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 对角翻转
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
            // 镜像翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = t;
                }
            }
        }
    }
}
