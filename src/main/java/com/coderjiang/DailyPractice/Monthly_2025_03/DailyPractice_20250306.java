package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-06 14:54:53</p>
 */
public class DailyPractice_20250306 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long beautifulSubarrays(int[] nums) {
            Map<Integer, Long> xors = new HashMap<>();
            xors.put(0, 1L);
            long res = 0;
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
                res += xors.getOrDefault(xor, 0L);
                xors.put(xor, xors.getOrDefault(xor, 0L) + 1);
            }
            return res;
        }
    }

}
