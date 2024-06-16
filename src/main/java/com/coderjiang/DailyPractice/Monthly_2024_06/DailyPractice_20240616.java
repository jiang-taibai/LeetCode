package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-16 14:42:02</p>
 */
public class DailyPractice_20240616 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findLUSlength(String a, String b) {
            return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
        }
    }

}
