package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-11-16 12:54:08</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_16 {

    class Solution {

        public static final int MAXSIZE = (int) (2 * 1e5 + 10);

        public boolean isRectangleCover(int[][] rectangles) {
            int left = rectangles[0][0];
            int down = rectangles[0][1];
            int right = rectangles[0][2];
            int up = rectangles[0][3];
            Map<Point, Integer> map = new HashMap<>();
            long allArea = 0;
            for (int[] rectangle : rectangles) {
                int x = rectangle[0], y = rectangle[1], a = rectangle[2], b = rectangle[3];

                left = Math.min(left, x);
                down = Math.min(down, y);
                right = Math.max(right, a);
                up = Math.max(up, b);

                allArea += (long) (a - x) * (b - y);
                Point ld = new Point(x, y);
                Point lu = new Point(x, b);
                Point ru = new Point(a, b);
                Point rd = new Point(a, y);
                map.put(ld, map.getOrDefault(ld, 0) + 1);
                map.put(lu, map.getOrDefault(lu, 0) + 1);
                map.put(ru, map.getOrDefault(ru, 0) + 1);
                map.put(rd, map.getOrDefault(rd, 0) + 1);
            }

            Point ld = new Point(left, down);
            Point lu = new Point(left, up);
            Point ru = new Point(right, down);
            Point rd = new Point(right, down);
            if (allArea != (long) (right - left) * (up - down) ||
                    map.getOrDefault(ld, 0) != 1 ||
                    map.getOrDefault(lu, 0) != 1 ||
                    map.getOrDefault(ru, 0) != 1 ||
                    map.getOrDefault(rd, 0) != 1) return false;
            map.remove(ld);
            map.remove(lu);
            map.remove(ru);
            map.remove(rd);

            for (Map.Entry<Point, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 2 && entry.getValue() != 4) return false;
            }
            return true;
        }

        class Point {

            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return x * 97 + y;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Point) {
                    Point p = (Point) obj;
                    return p.x == this.x && p.y == this.y;
                }
                return false;
            }
        }
    }

}
