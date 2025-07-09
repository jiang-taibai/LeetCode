package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-27 11:02:36</p>
 */
public class DailyPractice_20250527 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int differenceOfSums(int n, int m) {
            int res = 0;
            for (int i = 1; i <= n; ++i) {
                if (i % m == 0) res -= i;
                else res += i;
            }
            return res;
        }
    }

}
