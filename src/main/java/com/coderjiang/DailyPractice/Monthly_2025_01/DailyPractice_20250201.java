package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-01 09:11:23</p>
 */
public class DailyPractice_20250201 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            if (nums[0] == target) return true;
            if (nums[n - 1] == target) return true;
            if (nums[0] < target) {
                for (int i = 1; i < n; i++) {
                    if (nums[i] == target) return true;
                    if (nums[i] < nums[i - 1]) return false;
                }
            } else {
                for (int i = n - 2; i >= 0; i--) {
                    if (nums[i] == target) return true;
                    if (nums[i + 1] < nums[i]) return false;
                }
            }
            return false;
        }
    }

}
