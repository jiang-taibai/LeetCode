package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-19 10:52:04</p>
 */
public class DailyPractice_20250319 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<List<Integer>> res = new ArrayList<>();
            while (!map.isEmpty()) {
                List<Integer> line = new ArrayList<>();
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    line.add(entry.getKey());
                    if (entry.getValue() == 1) it.remove();
                    else entry.setValue(entry.getValue() - 1);
                }
                res.add(line);
            }
            return res;
        }
    }

}
