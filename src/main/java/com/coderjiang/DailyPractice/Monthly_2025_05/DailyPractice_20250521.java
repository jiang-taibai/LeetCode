package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-21 22:29:55</p>
 */
public class DailyPractice_20250521 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int l = 0, r = queries.length - 1;
            int res = queries.length;
            if (check(nums, queries, -1)) return 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (check(nums, queries, mid)) {
                    res = Math.min(res, mid);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return res == queries.length ? -1 : res + 1;
        }

        private boolean check(int[] nums, int[][] queries, int k) {
            int n = nums.length;
            int[] diff = new int[n + 1];
            for (int i = 0; i <= k; ++i) {
                diff[queries[i][0]] += queries[i][2];
                diff[queries[i][1] + 1] -= queries[i][2];
            }
            int sub = 0;
            for (int i = 0; i < n; ++i) {
                sub += diff[i];
                if (nums[i] > sub) return false;
            }
            return true;
        }
    }

}
