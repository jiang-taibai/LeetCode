package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-02 03:42:53</p>
 */
public class DailyPractice_20240702 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximumPrimeDifference(int[] nums) {
            int n = nums.length;
            boolean[] prime = getAllPrimes(100);
            int lhs = 0, rhs = 0;
            for (int i = 0; i < n; i++) {
                if (prime[nums[i]]) {
                    lhs = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (prime[nums[i]]) {
                    rhs = i;
                    break;
                }
            }
            return rhs - lhs;
        }

        private boolean[] getAllPrimes(int n) {
            boolean[] prime = new boolean[n + 1];
            Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    for (int j = i + i; j <= n; j += i) {
                        prime[j] = false;
                    }
                }
            }
            return prime;
        }
    }

}
