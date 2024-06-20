package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-21 07:01:53</p>
 */
public class DailyPractice_20240621 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
            int res = 0, count = 0;
            int n = temperatureA.length;
            for (int i = 0; i < n - 1; i++) {
                if (sameTendency(temperatureA, temperatureB, i)) {
                    count++;
                } else {
                    res = Math.max(res, count);
                    count = 0;
                }
            }
            res = Math.max(res, count);
            return res;
        }

        private int tendency(int[] arr, int i) {
            return Integer.compare(arr[i + 1], arr[i]);
        }

        private boolean sameTendency(int[] ta, int[] tb, int i) {
            return tendency(ta, i) == tendency(tb, i);
        }
    }

}
