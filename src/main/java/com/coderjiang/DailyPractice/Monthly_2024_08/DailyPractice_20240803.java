package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-03 12:52:23</p>
 */
public class DailyPractice_20240803 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxPointsInsideSquare(int[][] points, String s) {
            int n = points.length;
            for (int i = 0; i < n; i++) {
                points[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
                points[i][1] = s.charAt(i) - 'a';
            }
            Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
            boolean[] set = new boolean[26];
            int index = 0;
            int res = 0;
            while (index<n) {
                int dis = points[index][0];
                int count = 0;
                while(index<n && points[index][0]==dis) {
                    if(!set[points[index][1]]) {
                        set[points[index][1]] = true;
                    } else {
                        return res;
                    }
                    count++;
                    index++;
                }
                res += count;
            }
            return res;
        }
    }

}
