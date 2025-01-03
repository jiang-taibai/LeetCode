package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-03 11:11:02</p>
 */
public class DailyPractice_20250103 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        static class MyCalendarTwo {

            List<int[]> booked = new ArrayList<>();
            List<int[]> overlaps = new ArrayList<>();

            public MyCalendarTwo() {

            }

            public boolean book(int startTime, int endTime) {
                for (int[] overlap : overlaps) {
                    if(overlap[1] > startTime && overlap[0] < endTime) {
                        return false;
                    }
                }
                for (int[] schedule : booked) {
                    if(schedule[1] > startTime && schedule[0] < endTime) {
                        overlaps.add(new int[]{
                                Math.max(startTime, schedule[0]),
                                Math.min(endTime, schedule[1])
                        });
                    }
                }
                booked.add(new int[]{startTime, endTime});
                return true;
            }
        }
    }

}
