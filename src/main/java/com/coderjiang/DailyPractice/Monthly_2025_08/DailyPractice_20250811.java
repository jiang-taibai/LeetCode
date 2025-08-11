package com.coderjiang.DailyPractice.Monthly_2025_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-08-11 20:05:23</p>
 */
public class DailyPractice_20250811 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] productQueries(int n, int[][] queries) {
            List<Integer> nums = new ArrayList<>();
            int i = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    nums.add(i);
                }
                n >>= 1;
                ++i;
            }
            n = nums.size();
            int[] preSum = new int[n + 1];
            for (i = 1; i <= n; ++i) {
                preSum[i] = preSum[i - 1] + nums.get(i - 1);
            }
            int[] ans = new int[queries.length];
            i = 0;
            final int MOD = (int) (1e9 + 7);
            for (int[] query : queries) {
                ans[i++] = powerMod(2, preSum[query[1] + 1] - preSum[query[0]], MOD);
            }
            return ans;
        }

        private int powerMod(int x, int n, int mod) {
            // System.out.println(n);
            int res = 1;
            for (int i = 0; i < n; ++i) {
                res *= x;
                res %= mod;
            }
            return res;
        }
    }

}
