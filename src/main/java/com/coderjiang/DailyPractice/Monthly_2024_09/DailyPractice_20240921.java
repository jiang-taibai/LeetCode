package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-21 13:34:18</p>
 */
public class DailyPractice_20240921 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int edgeScore(int[] edges) {
            int n = edges.length;
            long[] cnt = new long[n + 1];
            for (int i = 0; i < n; i++) {
                cnt[edges[i]] += i;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (cnt[i] > cnt[res]) res = i;
            }
            return res;
        }
    }

}
