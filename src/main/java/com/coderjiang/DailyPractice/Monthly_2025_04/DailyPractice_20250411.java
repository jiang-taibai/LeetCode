package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-11 19:12:09</p>
 */
public class DailyPractice_20250411 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int res = 0;
            for (int i = low; i <= high; ++i) {
                if (valid(i)) res++;
            }
            return res;
        }

        private boolean valid(int num) {
            int[] arr = new int[5];
            int len = 0;
            while (num != 0) {
                arr[len++] = num % 10;
                num /= 10;
            }
            if (len % 2 == 1) return false;
            int preSum = 0, postSum = 0;
            for (int i = 0; i < len / 2; ++i) {
                postSum += arr[i];
                preSum += arr[len - i - 1];
            }
            return preSum == postSum;
        }
    }

}
