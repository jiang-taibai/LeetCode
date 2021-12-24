package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2021-12-24 09:38:34</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_24 {

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            int res = 0;
            int i = 0;
            for (i = 0; i < apples.length; i++) {
                if (apples[i] != 0) {
                    pq.add(new int[]{i + days[i], apples[i]});
                }
                while (pq.size() > 0 && pq.peek()[0] <= i) pq.poll();
                if (pq.size() > 0 && pq.peek()[1] > i) {
                    pq.peek()[1]--;
                    res++;
                    if (pq.peek()[1] == 0) {
                        pq.poll();
                    }
                }
            }
            while (pq.size() > 0) {
                while (pq.size() > 0 && pq.peek()[0] <= i) pq.poll();
                int temp = 0;
                if (!pq.isEmpty()) {
                    temp = Math.min(pq.peek()[0] - i, pq.peek()[1]);
                    // System.out.printf("pq.peek()[0] - i = %d\n", pq.peek()[0] - i);
                    // System.out.printf("pq.peek()[1] = %d\n", pq.peek()[1]);
                }
                res += temp;
                i += temp;
                pq.poll();
            }
            return res;
        }
    }

}
