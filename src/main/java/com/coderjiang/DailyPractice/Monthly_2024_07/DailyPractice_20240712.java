package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-12 11:16:53</p>
 */
public class DailyPractice_20240712 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] numberGame(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                nums[i] ^= nums[i + 1];
                nums[i + 1] ^= nums[i];
                nums[i] ^= nums[i + 1];
            }
            return nums;
        }
    }

}
