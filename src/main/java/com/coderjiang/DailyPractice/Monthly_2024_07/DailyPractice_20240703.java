package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-03 14:55:55</p>
 */
public class DailyPractice_20240703 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int sumOfTheDigitsOfHarshadNumber(int x) {
            int num = x;
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            return num % sum == 0 ? sum : -1;
        }
    }

}
