package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Creation Time: 2021-12-29 11:08:25</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_29 {

    class Solution {
        public int countQuadruplets(int[] nums) {
            int n = nums.length;
            Set<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int i1 = i + 1; i1 < n; i1++) {
                    for (int i2 = i1 + 1; i2 < n; i2++) {
                        for (int i3 = i2 + 1; i3 < n; i3++) {
                            if (nums[i] + nums[i1] + nums[i2] == nums[i3]) res++;
                        }
                    }
                }
            }
            return res;
        }
    }

}
