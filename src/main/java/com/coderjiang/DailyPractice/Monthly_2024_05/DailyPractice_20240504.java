package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-04 11:03:06</p>
 */
public class DailyPractice_20240504 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[] jobIndexSortedByEndTime =
                    IntStream.range(0, n)
                            .boxed()
                            .sorted(Comparator.comparingInt(i -> endTime[i]))
                            .mapToInt(i -> i)
                            .toArray();
            int maxProfit = 0;
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            treeMap.put(0, maxProfit);
            for (int index : jobIndexSortedByEndTime) {
                maxProfit = Math.max(maxProfit, treeMap.floorEntry(startTime[index]).getValue() + profit[index]);
                treeMap.put(endTime[index], maxProfit);
            }
            return maxProfit;
        }

    }
}