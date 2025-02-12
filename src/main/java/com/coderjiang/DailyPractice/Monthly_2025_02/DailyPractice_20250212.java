package com.coderjiang.DailyPractice.Monthly_2025_02;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-12 14:36:54</p>
 */
public class DailyPractice_20250212 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int l = 1, r = (int) 1e9;
            while (l < r) {
                int mid = (l + r) / 2;
                int needOperations = 0;
                for (int num : nums) {
                    needOperations += num / mid;
                    if (num % mid == 0) needOperations--;
                }
                if(needOperations > maxOperations) l = mid + 1;
                else {
                    r = mid;
                }
            }
            return r;
        }
    }

}
