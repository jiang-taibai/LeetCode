package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-22 23:07:51</p>
 */
public class DailyPractice_20241122 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int nonSpecialCount(int l, int r) {
            int res = 0;
            int leftBound = Math.max(2, (int) Math.sqrt(l) - 10);
            int rightBound = (int) (Math.sqrt(r) + 10);
            boolean[] isPrime = getIsPrimeArray(rightBound);
            for (int i = leftBound; i < rightBound; i++) {
                if (i * i < l || i * i > r) continue;
                if (isPrime[i]) res++;
            }
            return r - l + 1 - res;
        }

        boolean[] getIsPrimeArray(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i + i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            return isPrime;
        }
    }

}
