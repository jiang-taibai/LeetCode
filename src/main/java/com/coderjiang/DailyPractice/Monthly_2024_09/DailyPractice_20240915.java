package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-15 11:38:07</p>
 */
public class DailyPractice_20240915 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            int[] diff = new int[100 + 10];
            for (List<Integer> range : nums) {
                diff[range.get(0)]++;
                diff[range.get(1) + 1]--;
            }
            int res = 0, sum = 0;
            for (int i : diff) {
                sum += i;
                if (sum > 0) res++;
            }
            return res;
        }
    }

}
