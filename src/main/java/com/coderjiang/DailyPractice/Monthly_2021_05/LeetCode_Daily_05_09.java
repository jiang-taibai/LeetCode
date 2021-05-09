package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>创建时间：2021/5/9 11:48</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_09 {

    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            if (m * k > n) return -1;
            int[] minDay = new int[n - k + 1];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
            for (int i = 0; i <= k - 2; ++i) {
                priorityQueue.add(bloomDay[i]);
            }
            for (int i = k - 1; i < minDay.length; ++i) {
                priorityQueue.add(bloomDay[i]);
                minDay[i - k + 1] = priorityQueue.peek();
                priorityQueue.remove(bloomDay[i - k + 1]);
            }
            System.out.println(Arrays.toString(minDay));
            return 0;
        }
    }

}
