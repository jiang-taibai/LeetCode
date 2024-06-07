package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-07 21:09:56</p>
 */
public class DailyPractice_20240607 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxOperations(int[] nums) {
            int target = nums[0] + nums[1];
            int count = 0;
            for (int i = 0; i < nums.length; i += 2) {
                if (i + 1 < nums.length && nums[i] + nums[i + 1] == target) count++;
                else break;
            }
            return count;
        }
    }

}
