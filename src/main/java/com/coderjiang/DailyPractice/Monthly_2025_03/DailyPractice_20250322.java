package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-22 18:24:18</p>
 */
public class DailyPractice_20250322 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int[] res = new int[]{0, 0};
            for (int i = 0; i < mat.length; ++i) {
                int count = 0;
                for (int j = 0; j < mat[i].length; ++j) {
                    if (mat[i][j] == 1) count++;
                }
                if (count > res[1]) {
                    res[0] = i;
                    res[1] = count;
                }
            }
            return res;
        }
    }

}
