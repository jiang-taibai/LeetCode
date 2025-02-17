package com.coderjiang.DailyPractice.Monthly_2025_02;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-17 14:36:54</p>
 */
public class DailyPractice_20250217 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findSpecialInteger(int[] arr) {
            int n = arr.length;
            int count = 1;
            int num = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i] == num) {
                    count++;
                } else {
                    count = 1;
                    num = arr[i];
                }
                if (count > n / 4) return num;
            }
            return arr[n - 1];
        }
    }

}
