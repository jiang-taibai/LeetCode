package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Creation Time: 2022-01-18 15:13:10</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_18 {

    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();
            List<Integer> times = new ArrayList<>();
            for (String timePoint : timePoints) {
                String[] nums = timePoint.split(":");
                int time = Integer.parseInt(nums[0]) * 60 + Integer.parseInt(nums[1]);
                times.add(time);
            }
            Collections.sort(times);
            int minTimeGap = Integer.MAX_VALUE;
            int MOD = 24 * 60;
            for (int i = 0; i < n; i++) {
                int preTime = times.get((i - 1 + n) % n);
                int curTime = times.get(i);
                int gap = Math.min(
                        Math.abs((curTime - preTime + MOD) % MOD),
                        Math.abs((preTime - curTime + MOD) % MOD));
                minTimeGap = Math.min(minTimeGap, gap);
            }
            return minTimeGap;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
    }

}
