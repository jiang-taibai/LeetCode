package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-09 13:09:11</p>
 */
public class DailyPractice_20240709 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumDistance(int[][] points) {
            TreeMap<Integer, Integer> sx = new TreeMap<Integer, Integer>();
            TreeMap<Integer, Integer> sy = new TreeMap<Integer, Integer>();
            for (int[] p : points) {
                sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
                sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
            }
            int res = Integer.MAX_VALUE;
            for (int[] p : points) {
                sx.put(p[0] - p[1], sx.get(p[0] - p[1]) - 1);
                if (sx.get(p[0] - p[1]) == 0) {
                    sx.remove(p[0] - p[1]);
                }
                sy.put(p[0] + p[1], sy.get(p[0] + p[1]) - 1);
                if (sy.get(p[0] + p[1]) == 0) {
                    sy.remove(p[0] + p[1]);
                }
                res = Math.min(res, Math.max(sx.lastKey() - sx.firstKey(), sy.lastKey() - sy.firstKey()));
                sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
                sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
            }
            return res;
        }
    }

}
