package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-08 12:47:22</p>
 */
public class DailyPractice_20240508 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int step = 0;
            int resCapacity = capacity;
            for (int i = 0; i < plants.length - 1; i++) {
                int cur = plants[i];
                int next = plants[i + 1];
                step++;
                resCapacity -= cur;
                if (resCapacity < next) {
                    step += (i + 1) << 1;
                    resCapacity = capacity;
                }
            }
            return step + 1;
        }
    }

}
