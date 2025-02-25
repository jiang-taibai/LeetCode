package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-22 17:01:37</p>
 */
public class DailyPractice_20250122 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int l = 0, r = piles.length - 1;
            int res = 0;
            while (l < r) {
                res += piles[r - 1];
                r -= 2;
                l++;
            }
            return res;
        }
    }

}
