package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-19 00:38:36</p>
 */
public class DailyPractice_20240719 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumLevels(int[] possible) {
            int n = possible.length;
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (possible[i] == 1) {
                    preSum[i + 1] = preSum[i] + 1;
                } else {
                    preSum[i + 1] = preSum[i] - 1;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (preSum[i + 1] > preSum[n] - preSum[i + 1]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

}
