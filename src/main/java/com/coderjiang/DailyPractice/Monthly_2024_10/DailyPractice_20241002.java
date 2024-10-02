package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-02 09:15:22</p>
 */
public class DailyPractice_20241002 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int l = 1, r = (int) 1e7;
            int res = -1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                double cost = calCost(dist, mid);
                if (cost <= hour) {
                    r = mid - 1;
                    if (res == -1) res = mid;
                    else res = Math.min(res, mid);
                } else if (cost > hour) {
                    l = mid + 1;
                }
            }
            return res;
        }

        private double calCost(int[] dist, int speed) {
            double cost = 0;
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    cost += 1.0 * dist[i] / speed;
                } else {
                    cost += Math.ceil(1.0 * dist[i] / speed);
                }
            }
//            System.out.println(Arrays.toString(dist));
//            System.out.println("speed = " + speed + ", cost = " + cost);
            return cost;
        }
    }

}
/*

 */
