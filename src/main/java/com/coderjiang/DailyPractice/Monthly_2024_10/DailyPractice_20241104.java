package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-04 16:09:28</p>
 */
public class DailyPractice_20241104 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0, right = (int) Math.sqrt(c);
            for (int i = left; i <= right; i++) {
                int restNumber = c - i * i;
                int restNumberSqrt = (int) Math.sqrt(restNumber);
                if (restNumberSqrt * restNumberSqrt == restNumber) return true;
            }
            return false;
        }
    }

}
