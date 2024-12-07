package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-07 10:40:09</p>
 */
public class DailyPractice_20241207 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int[][] directions = new int[][]{
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {2, -1}, {2, 1}, {1, -2}, {1, 2},
        };

        private int n;

        private BigDecimal[][][] memo;

        public double knightProbability(int n, int k, int row, int column) {
            this.n = n;
            this.memo = new BigDecimal[n + 1][n + 1][k + 1];
            for (BigDecimal[][] a : this.memo) {
                for (BigDecimal[] b : a) {
                    Arrays.fill(b, BigDecimal.ONE.negate());
                }
            }
            BigDecimal stayConditions = dfs(row, column, k);
            return stayConditions.divide(BigDecimal.valueOf(8).pow(k)).doubleValue();
        }

        private BigDecimal dfs(int row, int col, int k) {
            if (!stayOnTheBoard(row, col)) return BigDecimal.ZERO;
            if (k == 0) return BigDecimal.ONE;
            if (!memo[row][col][k].equals(BigDecimal.ONE.negate())) return memo[row][col][k];
            BigDecimal res = BigDecimal.ZERO;
            for (int[] direction : directions) {
                res = res.add(dfs(row + direction[0], col + direction[1], k - 1));
            }
            memo[row][col][k] = res;
            return res;
        }

        private boolean stayOnTheBoard(int row, int col) {
            return row >= 0 && col >= 0 && row < n && col < n;
        }

    }

}
