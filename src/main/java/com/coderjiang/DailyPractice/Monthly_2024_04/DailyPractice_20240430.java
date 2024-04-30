package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-30 09:16:51</p>
 */
public class DailyPractice_20240430 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            return (int) Arrays.stream(hours).filter(i -> i >= target).count();
        }
    }

}
