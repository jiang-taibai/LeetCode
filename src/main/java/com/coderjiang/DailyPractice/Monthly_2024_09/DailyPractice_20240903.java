package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-03 11:21:08</p>
 */
public class DailyPractice_20240903 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maxStrength(int[] nums) {
            Arrays.sort(nums);
            int negativeCount = 0;
            for (int num : nums) if (num < 0) negativeCount++;
            if ((negativeCount & 1) == 1) negativeCount--;
            boolean isEmpty = true;
            long res = 1;
            for (int i = 0; i < negativeCount; i++) {
                res *= nums[i];
                isEmpty = false;
            }
            for (int i = negativeCount; i < nums.length; i++) {
                if (nums[i] <= 0) continue;
                res *= nums[i];
                isEmpty = false;
            }
            return isEmpty ? nums[nums.length - 1] : res;
        }
    }

}
