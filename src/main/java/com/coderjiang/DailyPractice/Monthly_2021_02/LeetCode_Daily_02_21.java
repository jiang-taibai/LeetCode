package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>创建时间：2021/2/21 11:19</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_21 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            // Stores numbers in descending order
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            // Stores numbers in ascending order
            PriorityQueue<Integer> minQueue = new PriorityQueue<>(Integer::compareTo);

            int n = nums.length;
            int lhs = 0, rhs = 0;
            int maxLen = 0;
            while (rhs < n) {
                maxQueue.offer(nums[rhs]);
                minQueue.offer(nums[rhs]);
                System.out.println("maxQueue.peek() = " + maxQueue.peek());
                System.out.println("minQueue.peek() = " + minQueue.peek());

                while (maxQueue.peek() - minQueue.peek() > limit) {
                    maxQueue.remove(nums[lhs]);
                    minQueue.remove(nums[lhs]);
                    System.out.println("lhs=" + lhs);
                    lhs++;
                }
                maxLen = Math.max(maxLen, rhs - lhs + 1);
                System.out.println("rhs=" + rhs);
                rhs++;
            }
            return maxLen;
        }
    }
}
