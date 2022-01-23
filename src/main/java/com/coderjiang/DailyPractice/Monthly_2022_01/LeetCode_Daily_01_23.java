package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * <p>Creation Time: 2022-01-23 00:06:55</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_23 {

    class StockPrice {

        private int latestTimestamp = -1;
        private final HashMap<Integer, Integer> timeToPrice = new HashMap<>();
        private final TreeMap<Integer, Integer> priceCount = new TreeMap<>();

        public StockPrice() {
        }

        public void update(int timestamp, int price) {
            if (timeToPrice.containsKey(timestamp)) {
                int oldPrice = timeToPrice.get(timestamp);
                priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
                if (priceCount.get(oldPrice) == 0) {
                    priceCount.remove(oldPrice);
                }
            }
            timeToPrice.put(timestamp, price);
            priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
            latestTimestamp = Math.max(latestTimestamp, timestamp);
        }

        public int current() {
            return timeToPrice.get(latestTimestamp);
        }

        public int maximum() {
            return priceCount.lastKey();
        }

        public int minimum() {
            return priceCount.firstKey();
        }

    }

    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */


}
