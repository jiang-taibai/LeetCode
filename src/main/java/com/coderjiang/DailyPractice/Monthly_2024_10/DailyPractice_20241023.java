package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-23 13:47:44</p>
 */
public class DailyPractice_20241023 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countCompleteDayPairs(int[] hours) {
            int[] modHours = new int[24];
            for (int hour : hours) {
                modHours[hour % 24]++;
            }
            long res = 0;
            if (modHours[0] >= 2) {
                res += numberOfCombinations(modHours[0]);
            }
            if (modHours[12] >= 2) {
                res += numberOfCombinations(modHours[12]);
            }
            for (int i = 1; i < 12; i++) {
                res += (long) modHours[i] * modHours[24 - i];
            }
            return res;
        }

        private long numberOfCombinations(int n) {
            return (long) n * (n - 1) / 2;
        }

    }

}
/*
0 0 0 0
3+2+1
n*(n-1)/2
4*3/2
0 0 0
2+1
3*2/2
 */
