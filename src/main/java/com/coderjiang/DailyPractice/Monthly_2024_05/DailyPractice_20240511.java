package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-11 02:36:08</p>
 */
public class DailyPractice_20240511 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            return sub(garbage, travel, 'M') +
                    sub(garbage, travel, 'P') +
                    sub(garbage, travel, 'G');
        }

        private int sub(String[] garbage, int[] travel, char target) {
            boolean needCollection = false;
            int res = 0;
            int previousTravel = 0;
            for (int i = 0; i < garbage.length; i++) {
                int count = count(garbage[i], target);
                if (count > 0) {
                    needCollection = true;
                    res += previousTravel + count;
                    previousTravel = 0;
                }
                if (i < garbage.length - 1) previousTravel += travel[i];
            }
            return needCollection ? res : 0;
        }

        private int count(String s, char c) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) res++;
            }
            return res;
        }
    }

}
