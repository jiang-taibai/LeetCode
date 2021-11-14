package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-11-14 13:52:19</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_14 {

    class MapSum {

        private Map<String, Integer> map = new HashMap<>();

        public MapSum() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int res = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().startsWith(prefix)) res += entry.getValue();
            }
            return res;
        }
    }

}
