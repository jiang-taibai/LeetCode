package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-06 05:38:13</p>
 */
public class DailyPractice_20240706 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            int l = 0, r = 0;
            long res = 0;
            int n = nums.length;
            while (l < n && r < n) {
                if (r + 1 < n && nums[r] != nums[r + 1]) {
                    r++;
                } else {
                    l = r + 1;
                    r = r + 1;
                }
                res += r - l + 1;
            }
            return res;
        }
    }

}
