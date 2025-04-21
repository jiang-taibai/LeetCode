package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-21 18:59:34</p>
 */
public class DailyPractice_20250421 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long minBoundary = lower, maxBoundary = upper;
            long addLower = 0, subtractUpper = 0;
            for (int difference : differences) {
                minBoundary += difference;
                maxBoundary += difference;
                addLower = Math.max(addLower, lower - minBoundary);
                subtractUpper = Math.max(subtractUpper, maxBoundary - upper);
            }
            return (int) Math.max(0L, (upper - subtractUpper) - (lower + addLower) + 1);
        }
    }

}
