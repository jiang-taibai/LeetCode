package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-05 08:33:05</p>
 */
public class DailyPractice_20241205 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
            // 车一步的情况
            if (a == e && (c != e ||                    // 三点不共线
                    (b - d) * (b - f) < 0 ||            // 三点共线，但象在 X 轴反方向
                    Math.abs(b - d) > Math.abs(b - f)   // 三点共线，象在正方向，但不在中间
            )) return 1;
            if (b == f && (d != f ||
                    (a - c) * (a - e) < 0 ||
                    Math.abs(a - c) > Math.abs(a - e)
            )) return 1;
            // 象一步的情况
            if (Math.abs(c - e) == Math.abs(d - f) && (
                    (f - b) * (e - c) != (e - a) * (f - d) ||   // 三点不共线
                            (a - e) * (c - e) < 0 ||            // 三点共线，但车在 X 轴反方向
                            (b - f) * (d - f) < 0 ||            // 三点共线，但车在 Y 轴反方向
                            Math.abs(a - e) > Math.abs(c - e)   // 三点共线，车在正方向，车不在中间
            )) return 1;
            return 2;
        }
    }

}
