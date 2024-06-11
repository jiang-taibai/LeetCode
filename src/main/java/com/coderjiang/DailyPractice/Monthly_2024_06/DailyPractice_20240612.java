package com.coderjiang.DailyPractice.Monthly_2024_06;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-12 00:16:53</p>
 */
public class DailyPractice_20240612 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int accountBalanceAfterPurchase(int purchaseAmount) {
            if (purchaseAmount % 10 == 0) {
                return 100 - purchaseAmount;
            } else if (purchaseAmount % 10 >= 5) {
                return 100 - (purchaseAmount / 10 + 1) * 10;
            } else {
                return 100 - (purchaseAmount / 10) * 10;
            }
        }
    }

}
