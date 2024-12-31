package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-31 09:52:18</p>
 */
public class DailyPractice_20241231 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));
            for (int cut : horizontalCut) pq.offer(new long[]{cut, 0});
            for (int cut : verticalCut) pq.offer(new long[]{cut, 1});
            int count0 = 1, count1 = 1;
            long res = 0;
            while (!pq.isEmpty()) {
                long[] cutConfig = pq.poll();
                if (cutConfig[1] == 0) {
                    count0++;
                    res += count1 * cutConfig[0];
                } else {
                    count1++;
                    res += count0 * cutConfig[0];
                }
            }
            return res;
        }
    }

}
