package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-29 00:02:12</p>
 */
public class DailyPractice_20241228 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean isPossibleToSplit(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int value = map.getOrDefault(num, 0);
                if (value >= 2) return false;
                map.put(num, value + 1);
            }
            long count = map.values().stream()
                    .filter(i -> i == 1)
                    .count();
            return (count & 1) == 0;
        }
    }

}
