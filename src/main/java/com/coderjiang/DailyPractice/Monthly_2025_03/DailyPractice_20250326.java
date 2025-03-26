package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-26 21:50:05</p>
 */
public class DailyPractice_20250326 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumSum(int n, int k) {
            if (k == 1 || k / 2 >= n) {
                // 取 [1, min{n, k/2}] 的和
                return intervalSum(1, n);
            } else {
                // [1, k/2] + [k, k+n-k/2-1]
                return intervalSum(1, k / 2) + intervalSum(k, k + (n - k / 2 - 1));
            }
        }

        private int intervalSum(int l, int r) {
            if (l > r) {
                int t = l;
                l = r;
                r = t;
            }
            return (l + r) * (r - l + 1) / 2;
        }
    }

}
