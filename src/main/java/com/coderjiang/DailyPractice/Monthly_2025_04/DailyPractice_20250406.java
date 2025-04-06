package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-06 12:41:28</p>
 */
public class DailyPractice_20250406 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int[] dp = new int[n];
            int maxDp = 0;
            for (int i = 0; i < n; ++i) {
                int maxSize = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] % nums[j] == 0) {
                        maxSize = Math.max(maxSize, dp[j] + 1);
                    }
                }
                dp[i] = maxSize;
                maxDp = Math.max(maxDp, maxSize);
            }
            int preDp = maxDp;
            int preNum = -1;
            List<Integer> res = new ArrayList<>();
            for (int i = n - 1; i >= 0; --i) {
                if (dp[i] == preDp) {
                    if (preNum == -1 || preNum % nums[i] == 0) {
                        res.add(nums[i]);
                        preNum = nums[i];
                        preDp--;
                    }
                }
            }
            Collections.reverse(res);
            return res;
        }
    }

}
