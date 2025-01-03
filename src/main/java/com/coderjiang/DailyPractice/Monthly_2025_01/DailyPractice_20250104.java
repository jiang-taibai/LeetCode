package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-04 02:30:16</p>
 */
public class DailyPractice_20250104 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class MyCalendarThree {

            private final TreeMap<Integer, Integer> map = new TreeMap<>();

            public MyCalendarThree() {

            }

            public int book(int startTime, int endTime) {
                map.put(startTime, map.getOrDefault(startTime, 0) + 1);
                map.put(endTime, map.getOrDefault(endTime, 0) - 1);
                int cnt = 0, maxK = 0;
                for (Integer value : map.values()) {
                    cnt += value;
                    maxK = Math.max(maxK, cnt);
                }
                return maxK;
            }
        }
    }

}
