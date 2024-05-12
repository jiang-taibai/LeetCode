package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-10 18:56:03</p>
 */
public class DailyPractice_20240512 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

        public int minDays(int n) {
            if (n <= 1) {
                return n;
            }
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
            return memo.get(n);
        }
    }

}
// n-n/3-n/3=m
// n/3=m
