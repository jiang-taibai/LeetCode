package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-17 15:38:23</p>
 */
public class DailyPractice_20240817 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            final Map<String, Integer> count = new HashMap<>();
            for (int i = 0; i < word.length(); i += k) {
                String subWord = word.substring(i, i + k);
                count.put(subWord, count.getOrDefault(subWord, 0) + 1);
            }
            int maxCount = 0;
            for (Integer value : count.values()) {
                maxCount = Math.max(maxCount, value);
            }
            return word.length() / k - maxCount;
        }
    }

}
