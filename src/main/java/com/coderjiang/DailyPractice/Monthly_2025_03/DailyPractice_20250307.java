package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-07 11:51:12</p>
 */
public class DailyPractice_20250307 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int beautifulSubsets(int[] nums, int k) {
            int n = nums.length;
            int[] conflit = new int[n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (Math.abs(nums[i] - nums[j]) == k) conflit[i] += 1 << j;
                }
            }
            return dfs(0, 0, n, conflit);
        }

        private int dfs(int select, int idx, int n, int[] conflit) {
            if (idx >= n) {
                return select == 0 ? 0 : 1;
            }
            int res = 0;
            if ((select & conflit[idx]) == 0) {
                // System.out.printf("%d <-> %d\n", select, conflit[idx]);
                res += dfs(select | (1 << idx), idx + 1, n, conflit);
            }
            res += dfs(select, idx + 1, n, conflit);
            return res;
        }

    }

}
