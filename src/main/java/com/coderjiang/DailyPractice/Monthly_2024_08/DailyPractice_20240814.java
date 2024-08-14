package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-14 20:48:27</p>
 */
public class DailyPractice_20240814 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            List<Integer> invalidIndexes = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n - 1; ++i) {
                if ((nums[i] & 1) == (nums[i + 1] & 1)) invalidIndexes.add(i);
            }
            boolean[] res = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0], r = queries[i][1];
                int goe = minGreaterOrEqual(invalidIndexes, l);
                int loe = maxLowerOrEqual(invalidIndexes, r - 1);
                res[i] = (goe == -1 || goe >= r) && (loe == -1 || loe < l);
            }
            return res;
        }

        private int minGreaterOrEqual(List<Integer> invalidIndexes, int num) {
            int l = 0, r = invalidIndexes.size() - 1;
            int res = Integer.MAX_VALUE;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (invalidIndexes.get(mid) < num) {
                    l = mid + 1;
                } else if (invalidIndexes.get(mid) == num) {
                    res = Math.min(mid, res);
                    l = mid + 1;
                } else {
                    res = Math.min(mid, res);
                    r = mid - 1;
                }
            }
            return res == Integer.MAX_VALUE ? -1 : invalidIndexes.get(res);
        }

        private int maxLowerOrEqual(List<Integer> invalidIndexes, int num) {
            int l = 0, r = invalidIndexes.size() - 1;
            int res = Integer.MIN_VALUE;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (invalidIndexes.get(mid) < num) {
                    res = Math.max(mid, res);
                    l = mid + 1;
                } else if (invalidIndexes.get(mid) == num) {
                    res = Math.max(mid, res);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return res == Integer.MIN_VALUE ? -1 : invalidIndexes.get(res);
        }
    }


}
