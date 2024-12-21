package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-21 14:33:01</p>
 */
public class DailyPractice_20241221 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, Comparator.comparingInt(a -> -a[k]));
            return score;
        }
    }

}
