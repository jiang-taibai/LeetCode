package com.coderjiang.DailyPractice.Monthly_2024_02;


import java.util.*;

/**
 * <p>Creation Time: 2024-02-05</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_05 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = nums[0];
            Deque<Integer> que = new ArrayDeque<>();
            que.offerLast(0);
            for (int i = 1; i < n; i++) {
                while (que.peekFirst() < i - k) que.pollFirst();
                dp[i] = dp[que.peekFirst()] + nums[i];
                while (!que.isEmpty() && dp[que.peekLast()] <= dp[i]) que.pollLast();
                que.offerLast(i);
            }
            return dp[n - 1];
        }
    }

}
