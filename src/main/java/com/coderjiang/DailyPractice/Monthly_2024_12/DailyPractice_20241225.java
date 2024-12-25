package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-25 09:53:45</p>
 */
public class DailyPractice_20241225 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
            for (int cut : horizontalCut) pq.offer(new int[]{cut, 0});
            for (int cut : verticalCut) pq.offer(new int[]{cut, 1});
            int count0 = 1, count1 = 1;
            int res = 0;
            while (!pq.isEmpty()) {
                int[] cutConfig = pq.poll();
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
