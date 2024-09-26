package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-26 09:53:20</p>
 */
public class DailyPractice_20240926 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int differenceOfSum(int[] nums) {
            int elementSum = Arrays.stream(nums).sum();
            int figureSum = Arrays.stream(nums).map(this::sumOfFigures).sum();
            return Math.abs(elementSum - figureSum);
        }

        private int sumOfFigures(int n) {
            int res = 0;
            while (n != 0) {
                res += n % 10;
                n /= 10;
            }
            return res;
        }
    }

}