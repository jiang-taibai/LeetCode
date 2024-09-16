package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-16 20:34:59</p>
 */
public class DailyPractice_20240916 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            if (start > destination) {
                int temp = start;
                start = destination;
                destination = temp;
            }
            int n = distance.length;
            int sum = 0, sumOfPart = 0;
            for (int i = 0; i < n; i++) {
                sum += distance[i];
                if (start <= i && i < destination) sumOfPart += distance[i];
            }
            return Math.min(sumOfPart, sum - sumOfPart);
        }
    }

}
