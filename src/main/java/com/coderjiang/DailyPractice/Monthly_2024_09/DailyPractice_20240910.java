package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-10 10:11:21</p>
 */
public class DailyPractice_20240910 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public long countQuadruplets(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            long res = 0;
            for (int j = 0; j < n; j++) {
                int suf = 0;
                for (int k = n - 1; k > j; k--) {
                    if (nums[k] < nums[j]) {
                        res += (long) pre[nums[k]] * suf;
                    } else {
                        suf++;
                    }
                }
                for (int x = nums[j] + 1; x <= n; x++) {
                    pre[x]++;
                }
            }
            return res;
        }

    }

}
