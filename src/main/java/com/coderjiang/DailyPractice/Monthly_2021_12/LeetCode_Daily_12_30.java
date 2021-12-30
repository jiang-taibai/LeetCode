package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Creation Time: 2021-12-30 10:18:44</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_30 {

    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int per : hand) {
                map.put(per, map.getOrDefault(per, 0) + 1);
            }
            while (!map.isEmpty()) {
                int start = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    start = entry.getKey();
                    break;
                }
                for (int i = 1; i < groupSize; i++) {
                    if (map.getOrDefault(start + i, 0) < map.get(start)) return false;
                }
                for (int i = 1; i < groupSize; i++) {
                    map.put(start + i, map.getOrDefault(start + i, 0) - map.get(start));
                    if (map.get(start + i) <= 0) map.remove(start + i);
                }
                map.remove(start);
            }
            return true;
        }
    }

}
