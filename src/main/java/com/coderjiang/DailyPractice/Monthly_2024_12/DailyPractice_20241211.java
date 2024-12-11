package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-11 08:54:40</p>
 */
public class DailyPractice_20241211 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int semiOrderedPermutation(int[] nums) {
            int n = nums.length;
            int indexOfOne = -1, indexOfN = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) indexOfOne = i;
                else if (nums[i] == n) indexOfN = i;
            }
            int step = indexOfOne + (n - 1 - indexOfN);
            if (indexOfOne > indexOfN) step--;
            return step;
        }
    }

}
