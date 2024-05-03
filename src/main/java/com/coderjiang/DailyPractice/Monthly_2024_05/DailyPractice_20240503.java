package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-03 11:47:39</p>
 */
public class DailyPractice_20240503 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public double average(int[] salary) {
            int maxSalary = 0, minSalary = Integer.MAX_VALUE;
            int sum = 0;
            for (int i : salary) {
                if (i > maxSalary) maxSalary = i;
                if (i < minSalary) minSalary = i;
                sum += i;
            }
            return (sum - minSalary - maxSalary) * 1.0 / (salary.length - 2);
        }
    }

}
