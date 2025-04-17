package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-17 09:46:41</p>
 */
public class DailyPractice_20250417 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countPairs(int[] nums, int k) {
            int n = nums.length, res = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] == nums[j] && i * j % k == 0) ++res;
                }
            }
            return res;
        }
    }

}
