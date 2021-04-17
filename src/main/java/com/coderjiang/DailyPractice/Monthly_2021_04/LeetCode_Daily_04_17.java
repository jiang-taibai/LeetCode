package com.coderjiang.DailyPractice.Monthly_2021_04;

import java.util.TreeSet;

/**
 * <p>创建时间：2021/4/17 11:14</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_04_17 {

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<Long>();
            for (int i = 0; i < n; i++) {
                Long ceiling = set.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }

}
