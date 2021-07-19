package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.*;

/**
 * <p>Creation Time: 2021-07-19 22:06:25</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_19 {

    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            int n = list.size();
            int maxFrequency = 0;
            for (int i = 0; i < n; i++) {
                int frequency = list.get(i).getValue();
                int restTimesOfModify = k;
                for (int j = i - 1; j >= 0; j--) {
                    int times = restTimesOfModify / (list.get(i).getKey() - list.get(j).getKey());
                    times = Math.min(times, list.get(j).getValue());
                    if(times == 0) break;
                    restTimesOfModify -= times * (list.get(i).getKey() - list.get(j).getKey());
                    frequency += times;
                }
                maxFrequency = Math.max(maxFrequency, frequency);
            }
            return maxFrequency;
        }
    }

}
