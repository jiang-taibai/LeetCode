package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-23 00:25:58</p>
 */
public class DailyPractice_20250423 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countLargestGroup(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            int maxSizeOfGroup = 0;
            int maxSizeOfGroupCount = 0;
            for (int i = 1; i <= n; ++i) {
                int sum = sumOfDigit(i);
                int currentSizeOfGroup = map.getOrDefault(sum, 0) + 1;
                map.put(sum, currentSizeOfGroup);
                if (currentSizeOfGroup == maxSizeOfGroup) {
                    maxSizeOfGroupCount++;
                } else if (currentSizeOfGroup > maxSizeOfGroup) {
                    maxSizeOfGroup = currentSizeOfGroup;
                    maxSizeOfGroupCount = 1;
                }
            }
            return maxSizeOfGroupCount;
        }

        private int sumOfDigit(int num) {
            int res = 0;
            while (num != 0) {
                res += num % 10;
                num /= 10;
            }
            return res;
        }
    }

}
