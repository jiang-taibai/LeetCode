package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_Daily_06_24 {

    class Solution {
        public int maxPoints(int[][] points) {
            int res = 1;
            for (int[] p1 : points) {
                int x1 = p1[0];
                int y1 = p1[1];
                Map<String, Integer> map = new HashMap<>();
                for (int[] p2 : points) {
                    int x2 = p2[0];
                    int y2 = p2[1];
                    if (x1 == x2 && y1 == y2) continue;
                    int subX = x1 - x2;
                    int subY = y1 - y2;
                    // 如果有0，说明要么是垂直，要么是水平的点
                    if (subX == 0 || subY == 0) {
                        String str = "垂直";
                        if (subX == 0) {
                            str = "水平";
                        }
                        map.put(str, map.getOrDefault(str, 1) + 1);
                        continue;
                    }
                    int factor = gcd(Math.abs(subX), Math.abs(subY));
                    subX /= factor;
                    subY /= factor;
                    // 保证分母不是负数
                    if (subY < 0) {
                        subX = -subX;
                        subY = -subY;
                    }
                    String index = String.format("(%d, %d)", subX, subY);
                    map.put(index, map.getOrDefault(index, 1) + 1);
                }
                int max = 1;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    max = Math.max(max, entry.getValue());
                }
                res = Math.max(res, max);
            }
            return res;
        }

        private int gcd(int x, int y) {
            return x == 0 ? y : gcd(y % x, x);
        }
    }

}