package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-27 13:07:31</p>
 */
public class DailyPractice_20250427 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countSubarrays(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i = 0; i + 2 < n; ++i) {
                if (nums[i + 1] == ((nums[i] + nums[i + 2]) << 1)) ++res;
            }
            return res;
        }
    }

}
