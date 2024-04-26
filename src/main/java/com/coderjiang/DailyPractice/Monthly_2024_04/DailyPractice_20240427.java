package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-27 00:24:26</p>
 */
public class DailyPractice_20240427 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[] res = new int[cols];
            for (int col = 0; col < cols; col++) {
                int maxLen = 0;
                for (int row = 0; row < rows; row++) {
                    maxLen = Integer.max(maxLen, getLenOfNumber(grid[row][col]));
                }
                res[col] = maxLen;
            }
            return res;
        }

        private int getLenOfNumber(int num) {
            if (num == 0) return 1;
            int len = 0;
            if (num < 0) {
                num = -num;
                len = 1;
            }
            while (num != 0) {
                len++;
                num /= 10;
            }
            System.out.println("len = " + len);
            return len;
        }
    }

}
