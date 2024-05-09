package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-09 12:29:03</p>
 */
public class DailyPractice_20240509 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int n = plants.length;
            int resA = capacityA, resB = capacityB;
            int result = 0;
            for (int i = 0; i < n / 2; i++) {
                if (resA < plants[i]) {
                    result++;
                    resA = capacityA;
                }
                resA -= plants[i];
            }
            for (int i = n - 1; i >= (n + 1) / 2; i--) {
                if (resB < plants[i]) {
                    result++;
                    resB = capacityB;
                }
                resB -= plants[i];
            }
            if ((n & 1) == 1) {
                if (resA == resB) {
                    if (resA < plants[n / 2]) result++;
                } else {
                    if (Integer.max(resA, resB) < plants[n / 2]) result++;
                }
            }
            return result;
        }
    }

}
