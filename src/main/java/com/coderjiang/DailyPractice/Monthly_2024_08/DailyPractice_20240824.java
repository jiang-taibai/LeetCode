package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-24 11:54:03</p>
 */
public class DailyPractice_20240824 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findPermutationDifference(String s, String t) {
            int[] indexes = new int[256];
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                indexes[s.charAt(i)] = i;
            }
            for (int i = 0; i < t.length(); i++) {
                res += Math.abs(indexes[t.charAt(i)] - i);
            }
            return res;
        }
    }

}
