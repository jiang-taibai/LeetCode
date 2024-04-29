package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-29 09:19:44</p>
 */
public class DailyPractice_20240429 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[] diagonal = null;
            for (int i = n - 1; i >= 0; i--) {
                diagonal = collectDiagonal(mat, i, 0, n, m);
                Arrays.sort(diagonal);
                setDiagonal(mat, i, 0, n, m, diagonal);
            }
            for (int j = 1; j < m; j++) {
                diagonal = collectDiagonal(mat, 0, j, n, m);
                Arrays.sort(diagonal);
                setDiagonal(mat, 0, j, n, m, diagonal);
            }
            return mat;
        }

        /**
         * 从 mat[i][j] 处开始收集左下角所有的数字，组成数组返回
         */
        private int[] collectDiagonal(int[][] mat, int i, int j, int n, int m) {
            int len = Integer.min(n - i, m - j);
            int[] res = new int[len];
            int idx = 0;
            while (i < n && j < m) {
                res[idx++] = mat[i++][j++];
            }
            return res;
        }

        /**
         * 从 mat[i][j] 处开始，用 diagonal 覆盖左下角对角线上的数字
         */
        private void setDiagonal(int[][] mat, int i, int j, int n, int m, int[] diagonal) {
            int len = Integer.min(n - i, m - j);
            if (diagonal.length != len) return;
            int idx = 0;
            while (i < n && j < m) {
                mat[i++][j++] = diagonal[idx++];
            }
        }
    }

}
