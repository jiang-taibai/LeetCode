package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-01 01:15:16</p>
 */
public class DailyPractice_20240901 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int cnt = 0, n = startTime.length;
            for (int i = 0; i < n; ++i) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) cnt++;
            }
            return cnt;
        }
    }

}
