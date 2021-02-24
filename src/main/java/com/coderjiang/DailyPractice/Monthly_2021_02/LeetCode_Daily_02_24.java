package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/24 0:24</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_24 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int rows = A.length;
            int cols = A[0].length;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < (cols + 1) / 2; ++j) {
                    int temp = Math.abs(A[i][j] - 1);
                    A[i][j] = Math.abs(A[i][cols - j - 1] - 1);
                    A[i][cols - j - 1] = temp;
                }
            }
            return A;
        }
    }
}
