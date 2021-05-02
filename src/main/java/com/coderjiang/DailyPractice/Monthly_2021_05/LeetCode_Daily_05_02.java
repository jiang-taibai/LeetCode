package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>创建时间：2021/6/1 15:59</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_02 {

    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (List<Integer> level : wall) {
                int index = 0;
                for (int i = 0; i < level.size() - 1; i++) {
                    index += level.get(i);
                    cnt.put(index, cnt.getOrDefault(index, 0) + 1);
                }
            }
            if (cnt.size() == 0) {
                return wall.size();
            }
            int max = cnt.values().stream().mapToInt(integer -> integer).summaryStatistics().getMax();
            return wall.size() - max;
        }
    }

}
