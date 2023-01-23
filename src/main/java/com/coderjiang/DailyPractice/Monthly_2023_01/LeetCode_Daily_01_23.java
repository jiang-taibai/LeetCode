package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-23 15:38:25</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_23 {

    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double result = 0;
            int preUpper = 0;
            int upper, percent;
            for (int[] bracket : brackets) {
                upper = Math.min(bracket[0], income);
                percent = bracket[1];
                result += (upper - preUpper) * percent / 100.0;
                if (income <= bracket[0]) break;
                preUpper = upper;
            }
            return result;
        }
    }

}
