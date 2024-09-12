package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-12 23:50:56</p>
 */
public class DailyPractice_20240912 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int res = 0;
            int l = 0, r = n / 2;
            while (l < n / 2 && r < n) {
                while (r < n && nums[l] * 2 > nums[r]) r++;
                if (r < n) res += 2;
                r++;
                l++;
            }
            return res;
        }
    }

}
