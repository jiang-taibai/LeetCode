package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.*;

/**
 * <p>Creation Time: 2021-07-10 11:01:30</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_10 {

    class TimeMap_Timeout {

        private final Map<String, List<String>> values = new HashMap<>();
        private final Map<String, List<Integer>> timestamps = new HashMap<>();

        /** Initialize your data structure here. */
        public TimeMap_Timeout() {}

        public void set(String key, String value, int timestamp) {
            List<String> valueList = values.getOrDefault(key, new ArrayList<>());
            valueList.add(value);
            values.put(key, valueList);

            List<Integer> timestampList = timestamps.getOrDefault(key, new ArrayList<>());
            timestampList.add(timestamp);
            timestamps.put(key, timestampList);
        }

        public String get(String key, int timestamp) {
            List<String> valueList = values.getOrDefault(key, new ArrayList<>());
            List<Integer> timestampList = timestamps.getOrDefault(key, new ArrayList<>());
            String preValue = "";
            for (int i = 0; i < timestampList.size(); i++) {
                if(timestampList.get(i) > timestamp) {
                    break;
                }
                preValue = valueList.get(i);
            }
            return preValue;
        }
    }

    class TimeMap {

        private final Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        /** Initialize your data structure here. */
        public TimeMap() {}

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) return "";
            TreeMap<Integer, String> treeMap = map.get(key);
            Integer targetTimestamp = treeMap.floorKey(timestamp);
            if(targetTimestamp == null) return "";
            return treeMap.get(targetTimestamp);
        }
    }

}
