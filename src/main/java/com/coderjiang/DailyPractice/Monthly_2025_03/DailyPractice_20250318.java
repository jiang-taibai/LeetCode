package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-18 10:12:19</p>
 */
public class DailyPractice_20250318 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int diagonalPrime(int[][] nums) {
            int n = nums.length;
            int maxPrime = 0;
            for (int i = 0; i < n; ++i) {
                if (isPrime(nums[i][i])) maxPrime = Math.max(maxPrime, nums[i][i]);
                if (isPrime(nums[i][n - i - 1])) maxPrime = Math.max(maxPrime, nums[i][n - i - 1]);
            }
            return maxPrime;
        }

        private boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

}
