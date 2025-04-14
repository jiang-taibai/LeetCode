package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-14 22:33:08</p>
 */
public class DailyPractice_20250414 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int n = arr.length;
            int res = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (Math.abs(arr[i] - arr[j]) > a) continue;
                    for (int k = j + 1; k < n; ++k) {
                        if (Math.abs(arr[j] - arr[k]) > b) continue;
                        if (Math.abs(arr[i] - arr[k]) > c) continue;
                        ++res;
                    }
                }
            }
            return res;
        }
    }

}
