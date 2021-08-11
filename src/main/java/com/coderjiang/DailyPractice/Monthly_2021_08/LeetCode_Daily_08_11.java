package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-08-11 11:30:44</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_11 {

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            Map<Long, Integer>[] f = new Map[n];
            for (int i = 0; i < n; i++) {
                f[i] = new HashMap<>();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    long d = 1L * nums[j] - nums[i];
                    int cnt = f[j].getOrDefault(d, 0);
                    ans += cnt;
                    f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
                }
            }
            return ans;
        }
    }

}
