package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.PriorityQueue;

/**
 * @author 刘江
 * @modifyTime 2021/1/2 21:20
 * @description TODO
 */
public class LeetCode_Daily_01_02 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                    (int[] a, int[] b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[0]);
            for (int i = 0; i < k; ++i) {
                priorityQueue.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = priorityQueue.peek()[0];
            for(int i=k;i<n;++i) {
                priorityQueue.offer(new int[] {nums[i], i});
                while(priorityQueue.peek()[1] <= i-k) {
                    priorityQueue.poll();
                }
                ans[i-k+1] = priorityQueue.peek()[0];
            }
            return ans;
        }
    }
}
