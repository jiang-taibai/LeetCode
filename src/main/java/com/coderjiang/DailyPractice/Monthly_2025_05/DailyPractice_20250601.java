package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-06-01 09:59:27</p>
 */
public class DailyPractice_20250601 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long distributeCandies(int n, int limit) {
            // a, b, c
            // 设定 a, c 不能超过 limit
            // b 取值范围为：[n-a-limit, n-a-0]
            long res = 0;
            for (int a = Math.max(n - limit - limit, 0); a <= Math.min(limit, n); ++a) {
                int minB = Math.max(n - a - limit, 0);
                int maxB = Math.min(n - a, limit);
                res += maxB - minB + 1;
            }
            return res;
        }
    }

}
