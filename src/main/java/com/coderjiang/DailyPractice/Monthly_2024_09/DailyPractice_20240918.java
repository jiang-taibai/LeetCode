package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-18 18:53:55</p>
 */
public class DailyPractice_20240918 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
            Arrays.sort(buses);
            Arrays.sort(passengers);
//            System.out.println("buses = " + Arrays.toString(buses));
//            System.out.println("passengers = " + Arrays.toString(passengers));
            int n = passengers.length;
            int[] preTime = new int[n];
            int time = passengers[0] - 1;
            preTime[0] = time;
            for (int i = 1; i < n; i++) {
                if (passengers[i] - 1 != passengers[i - 1]) time = passengers[i] - 1;
                preTime[i] = time;
            }
            int left = -2, right = -2;
            int res = -1;
            for (int busTime : buses) {
                if (left == -2) {
                    if (passengers[0] <= busTime) {
                        left = -1;
                        right = 0;
                    } else {
                        continue;
                    }
                }
                while (right + 1 < n && passengers[right + 1] <= busTime) right++;
//                System.out.printf("%d-%d\n", left, right);
                if (right - left < capacity) {
                    if (passengers[right] == busTime) res = preTime[right];
                    else res = busTime;
                    left = right;
                } else {
                    res = preTime[left + capacity];
                    left = left + capacity;
                }
            }
            if (res == -1) {
                res = buses[buses.length - 1];
            }
            return res;
        }
    }

}
