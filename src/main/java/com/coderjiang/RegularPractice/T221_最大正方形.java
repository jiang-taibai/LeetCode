package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 13:31:17</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T221_最大正方形 {

    class Solution_PrefixSum {

        private void analyse() {
            // 首先维护一个二维数组count
            //     count[i][j]表示从[0, 0]到[i, j]的数字'1'的个数
            // 然后再遍历每一个元素作为左上角坐标，记忆所遇到的最大的纯'1'矩阵的尺寸
        }

        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] count = new int[m][n];
            countNumber(matrix, count, m, n);
            int size = 1;
            int maxSize = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    while (check(matrix, count, i, j, m, n, size)) {
                        maxSize = size;
                        size++;
                    }
                }
            }
            return maxSize * maxSize;
        }

        private void countNumber(char[][] matrix, int[][] count, int m, int n) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int val = matrix[i][j] == '1' ? 1 : 0;
                    if (i != 0 && j != 0) {
                        count[i][j] = count[i - 1][j] + count[i][j - 1] - count[i - 1][j - 1] + val;
                    } else if (i == 0 && j != 0) {
                        count[i][j] = count[i][j - 1] + val;
                    } else if (i != 0 && j == 0) {
                        count[i][j] = count[i - 1][j] + val;
                    } else {
                        count[i][j] = val;
                    }
                    System.out.print(count[i][j] + " ");
                }
                System.out.println();
            }
        }

        private boolean check(char[][] matrix, int[][] count, int i, int j, int m, int n, int size) {
            size -= 1;
            if (i + size >= m || j + size >= n) return false;
            int countOfOne = count[i + size][j + size];
            if (i > 0 && j > 0)
                countOfOne = countOfOne - count[i - 1][j + size] - count[i + size][j - 1] + count[i - 1][j - 1];
            else if (i > 0 && j == 0) countOfOne = countOfOne - count[i - 1][j + size];
            else if (i == 0 && j > 0) countOfOne = countOfOne - count[i + size][j - 1];
            System.out.printf("i=%d, j=%d, size=%d, count=%d\n", i, j, size + 1, countOfOne);
            return countOfOne == (size + 1) * (size + 1);
        }
    }

    class Solution_DP {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            // dp[i][j]表示以matrix[i][j]为右下角顶点的最大正方形边长
            int[][] dp = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == '0') dp[i][j] = 0;
                    else {
                        if (i == 0 || j == 0) dp[i][j] = 1;
                        else {
                            dp[i][j] = Integer.min(dp[i - 1][j - 1], Integer.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                        }
                        res = Integer.max(res, dp[i][j]);
                    }
                }
            }
            return res * res;
        }
    }

}
