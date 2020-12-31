package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Arrays;

/**
 * @author 刘江
 * @modifyTime 2020/12/31 14:37
 * @description TODO
 */
public class LeetCode_Daily_12_31 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            int result = 0;
            int n = intervals.length;
            Arrays.sort(intervals, (lhs, rhs) -> lhs[1] - rhs[1]);
            int end = intervals[0][1];
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] > end) {
                    result++;
                    end = intervals[i][1];
                }
            }
            return n - result;
        }
    }
}
