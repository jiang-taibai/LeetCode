package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-29 20:41:27</p>
 */
public class DailyPractice_20250429 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countSubarrays(int[] nums, int k) {
            int maxNum = Arrays.stream(nums).max().getAsInt();
            List<Integer> maxNumIndexes = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; ++i) if (nums[i] == maxNum) maxNumIndexes.add(i);
            long res = 0;
            for (int i = 0; i + k - 1 < maxNumIndexes.size(); ++i) {
                long left = i == 0 ? maxNumIndexes.get(i) + 1 : maxNumIndexes.get(i) - maxNumIndexes.get(i - 1);
                long right = n - maxNumIndexes.get(i + k - 1);
                res += left * right;
            }
            return res;
        }
    }

}
