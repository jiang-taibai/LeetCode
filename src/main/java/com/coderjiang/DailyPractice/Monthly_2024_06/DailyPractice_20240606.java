package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-06 22:01:08</p>
 */
public class DailyPractice_20240606 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long minimumSteps(String s) {
            long res = 0, count = 0;
            for (int i = s.toCharArray().length - 1; i >= 0; i--) {
                if (s.charAt(i) == '1') res += count;
                else count++;
            }
            return res;
        }
    }

}
