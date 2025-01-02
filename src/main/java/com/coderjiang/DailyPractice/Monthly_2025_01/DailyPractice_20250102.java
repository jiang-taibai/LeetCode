package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-02 09:25:37</p>
 */
public class DailyPractice_20250102 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        class MyCalendar {

            class Schedule implements Comparable<Schedule> {
                int startTime, endTime;

                Schedule(int startTime, int endTime) {
                    this.startTime = startTime;
                    this.endTime = endTime;
                }

                @Override
                public int compareTo(Schedule o) {
                    if (startTime != o.startTime) return Integer.compare(startTime, o.startTime);
                    return Integer.compare(endTime, o.endTime);
                }
            }

            TreeSet<Schedule> schedules = new TreeSet<>();

            public MyCalendar() {

            }

            public boolean book(int startTime, int endTime) {
                Schedule schedule = new Schedule(startTime, endTime);
                Schedule floorSchedule = schedules.floor(schedule);
                if (floorSchedule != null && floorSchedule.endTime > schedule.startTime) {
                    return false;
                }
                Schedule ceilingSchedule = schedules.ceiling(schedule);
                if (ceilingSchedule != null && schedule.endTime > ceilingSchedule.startTime) {
                    return false;
                }
                schedules.add(schedule);
                return true;
            }
        }
    }

}
