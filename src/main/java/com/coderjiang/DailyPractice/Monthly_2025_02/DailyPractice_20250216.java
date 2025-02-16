package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-16 18:55:37</p>
 */
public class DailyPractice_20250216 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] replaceElements(int[] arr) {
            int max = -1;
            for (int i = arr.length - 1; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = max;
                max = Math.max(max, temp);
            }
            return arr;
        }
    }

}
