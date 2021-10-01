package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Creation Time: 2021-10-01 00:55:58</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class


LeetCode_Daily_10_01 {

    class Solution {
        public String destCity(List<List<String>> paths) {
            Map<String, String> next = new HashMap<>();
            for (List<String> path : paths) {
                next.put(path.get(0), path.get(1));
            }
            String curStationName = paths.get(0).get(0);
            while(next.containsKey(curStationName)) {
                curStationName = next.get(curStationName);
            }
            return curStationName;
        }
    }

}
