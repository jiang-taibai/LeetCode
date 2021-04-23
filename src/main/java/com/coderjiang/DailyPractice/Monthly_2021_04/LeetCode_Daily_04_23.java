package com.coderjiang.DailyPractice.Monthly_2021_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>创建时间：2021/4/23 7:22</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_04_23 {

    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.sort(nums);
            Arrays.fill(dp, 1);
            int maxVal = 1;
            int maxSize = 1;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }
            List<Integer> res = new ArrayList<>();
            if (maxVal == 1) {
                res.add(nums[0]);
                return res;
            }
            for (int i = n - 1; i >= 0; --i) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    res.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                }
            }
            return res;
        }
    }

}
