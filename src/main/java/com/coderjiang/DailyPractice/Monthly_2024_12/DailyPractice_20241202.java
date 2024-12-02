package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-02 11:30:21</p>
 */
public class DailyPractice_20241202 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int totalNQueens(int n) {
            return dfs(new boolean[n], new boolean[n * 2 - 1], new boolean[n * 2 - 1], 0, n);
        }

        private int dfs(boolean[] horizontal, boolean[] lrOblique, boolean[] rlOblique,
                        int row, int n) {
            if (row == n) {
                return 1;
            }
            int res = 0;
            for (int j = 0; j < n; j++) {
                int lrObliqueIndex = calLRObliqueIndex(row, j, n);
                int rlObliqueIndex = calRLObliqueIndex(row, j, n);
                if (!horizontal[j] && !lrOblique[lrObliqueIndex] && !rlOblique[rlObliqueIndex]) {
                    horizontal[j] = true;
                    lrOblique[lrObliqueIndex] = true;
                    rlOblique[rlObliqueIndex] = true;
                    res += dfs(horizontal, lrOblique, rlOblique, row + 1, n);
                    horizontal[j] = false;
                    lrOblique[lrObliqueIndex] = false;
                    rlOblique[rlObliqueIndex] = false;
                }
            }
            return res;
        }

        private int calLRObliqueIndex(int row, int col, int n) {
            // 2,3,4 -> 2
            // 0,0,4 -> 3
            // 0,3,4 -> 0
            // 3,0,4 -> 6
            return n + (row - col) - 1;
        }

        private int calRLObliqueIndex(int row, int col, int n) {
            return row + col;
        }
    }

}
