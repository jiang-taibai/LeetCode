package com.coderjiang.DailyPractice.Monthly_2021_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2021-12-14 02:05:58</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_14 {

    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            int total = 0;
            for (int[] course : courses) {
                if (total + course[0] <= course[1]) {
                    total += course[0];
                    pq.offer(course[0]);
                } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                    total -= pq.poll();
                    total += course[0];
                    pq.offer(course[0]);
                }
            }
            return pq.size();
        }
    }

}
