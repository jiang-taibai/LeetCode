package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/6</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_06 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findKOr(int[] nums, int k) {
            int res = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int num : nums) {
                    if ((num & mask) == mask) count++;
                    if (count >= k) {
                        res += mask;
                        break;
                    }
                }
                mask <<= 1;
            }
            return res;
        }
    }

}
