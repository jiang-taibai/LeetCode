package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-23 11:36:24</p>
 */
public class DailyPractice_20240923 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int n = values.length;
            int preMax = Integer.MIN_VALUE;
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                preMax = Math.max(preMax, values[i - 1] + (i - 1));
                res = Math.max(res, preMax + values[i] - i);
            }
            return res;
        }
    }

}
