package com.coderjiang.DailyPractice.Monthly_2021_05;

/**
 * <p>创建时间：2021/5/29 10:28</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_29 {

    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] prefix = new int[n + 1][m + 1];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
                    for (int k = 1; k <= i; k++) {
                        for (int l = 1; l <= j; l++) {
                            if (prefix[i][j] - prefix[i][l - 1] - prefix[k - 1][j] + prefix[k - 1][l - 1] == target) {
                                cnt++;
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }

}
