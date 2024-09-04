package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-04 11:46:24</p>
 */
public class DailyPractice_20240904 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countWays(List<Integer> nums) {
            Collections.sort(nums);
            int n = nums.size(), res = 0;
            for (int i = 0; i <= n; i++) {
                if (i > 0 && nums.get(i - 1) >= i) continue;
                if (i < n && nums.get(i) <= i) continue;
                res++;
            }
            return res;
        }
    }

}
