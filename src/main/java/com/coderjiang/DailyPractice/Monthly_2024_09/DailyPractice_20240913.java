package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-13 21:27:24</p>
 */
public class DailyPractice_20240913 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
            ArrayDeque<Integer> que = new ArrayDeque<>();
            int left = 0, right = 0;
            int n = chargeTimes.length;
            long sum = 0;
            int res = 0;
            while (right < n) {
                sum += runningCosts[right];
                while (!que.isEmpty() && chargeTimes[que.peekLast()] <= chargeTimes[right]) que.pollLast();
                que.offerLast(right);
                while (left <= right && (right - left + 1) * sum + chargeTimes[que.peekFirst()] > budget) {
                    if (!que.isEmpty() && que.peekFirst() == left) que.pollFirst();
                    sum -= runningCosts[left];
                    left++;
                }
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }

}
