package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-25 12:30:11</p>
 */
public class DailyPractice_20250125 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long minimumMoney(int[][] transactions) {
            long totalLoss = 0;
            long res = 0;
            for (int[] transaction : transactions) {
                int cost = transaction[0], cashback = transaction[1];
                if (cost > cashback) totalLoss += cost - cashback;
                res = Math.max(res, Math.min(cost, cashback));
            }
            return res + totalLoss;
        }
    }

}
