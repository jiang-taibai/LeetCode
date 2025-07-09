package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-09 20:33:03</p>
 */
public class DailyPractice_20250709 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            int n = startTime.length;
            int[] time = new int[n];
            int[] preTime = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                time[i] = endTime[i] - startTime[i];
                preTime[i + 1] = preTime[i] + time[i];
            }
            if (k == n) return eventTime - preTime[n];
            // 取 0 固定，往后 k 个挪动
            int maxRest = startTime[k] - preTime[k];
            for (int i = 0; i < n - k - 1; ++i) {
                int j = i + k + 1;
                // 取 i 和 j 固定，将中间的空闲时间加起来
                maxRest = Math.max(maxRest, (startTime[j] - endTime[i]) - (preTime[j] - preTime[i + 1]));
            }
            // 取 eventTime 固定，往前 k 个挪动
            maxRest = Math.max(maxRest, (eventTime - endTime[n - k - 1]) - (preTime[n] - preTime[n - k]));
            return maxRest;
        }
    }

}
