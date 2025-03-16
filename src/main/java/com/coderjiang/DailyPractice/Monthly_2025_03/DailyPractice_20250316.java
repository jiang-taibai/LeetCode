package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-16 13:25:58</p>
 */
public class DailyPractice_20250316 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int largestVariance(String s) {
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
            }
            int res = 0;
            for (char a : map.keySet()) {
                for (char b : map.keySet()) {
                    if (a == b) continue;
                    List<Integer> pa = map.get(a);
                    List<Integer> pb = map.get(b);
                    int i = 0, j = 0;
                    int f = 0, g = Integer.MIN_VALUE;
                    while (i < pa.size() || j < pb.size()) {
                        if (j == pb.size() || (i < pa.size() && pa.get(i) < pb.get(j))) {
                            f = Math.max(f, 0) + 1;
                            g = g + 1;
                            i++;
                        } else {
                            g = Math.max(g, Math.max(f, 0)) - 1;
                            f = Math.max(f, 0) - 1;
                            j++;
                        }
                        res = Math.max(res, g);
                    }
                }
            }
            return res;
        }
    }

}
