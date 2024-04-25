package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-10 01:12:27</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_63 {

    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }

}
