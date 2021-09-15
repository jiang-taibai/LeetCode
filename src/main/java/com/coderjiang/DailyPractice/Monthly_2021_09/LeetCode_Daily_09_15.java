package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-15 09:51:34</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_15 {

    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

}
