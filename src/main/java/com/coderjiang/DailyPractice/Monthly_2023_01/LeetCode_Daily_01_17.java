package com.coderjiang.DailyPractice.Monthly_2023_01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2023-01-19 14:32:24</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_17 {

    public static void main(String[] args) {

    }

    class Solution {

        public int countNicePairs(int[] nums) {
            // n1 + rev(n2) = n2 + rev(n1)
            // n1 - rev(n1) = n2 - rev(n2)
            final Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int key = num - rev(num);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            final int MOD = (int) (1e9 + 7);
            long result = 0;
            for (long value : map.values()) {
                result += value * (value - 1) / 2 % MOD;
            }
            return (int) (result % MOD);
        }

        private int rev(int num) {
            int revNum = 0;
            while (num != 0) {
                revNum = revNum * 10 + num % 10;
                num /= 10;
            }
            return revNum;
        }
    }

}
