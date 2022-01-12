package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-12 14:32:40</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_12 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= a) a = num;
                else if (num <= b) b = num;
                else return true;
            }
            return false;
        }
    }

}
