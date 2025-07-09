package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-19 09:22:39</p>
 */
public class DailyPractice_20250519 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String triangleType(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] + nums[1] <= nums[2]) return "none";
            if (nums[0] == nums[1] && nums[1] == nums[2]) return "equilateral";
            else if (nums[0] == nums[1] || nums[1] == nums[2]) return "isosceles";
            return "scalene";
        }
    }

}
