package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.PriorityQueue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-22 21:48:50</p>
 */
public class T30_堆_数组中的第K个最大元素 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int num : nums) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
            return pq.peek();
        }
    }

}
