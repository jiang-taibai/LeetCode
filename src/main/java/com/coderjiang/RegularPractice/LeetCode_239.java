package com.coderjiang.RegularPractice;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-29 10:51:06</p>
 */
public class LeetCode_239 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> que = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            que.offerLast(0);
            for (int i = 0; i < nums.length; i++) {
                while (!que.isEmpty() && que.peekFirst() <= i - k) que.pollFirst();
                while (!que.isEmpty() && nums[que.peekLast()] <= nums[i]) que.pollLast();
                que.offerLast(i);
                if (i >= k - 1) res.add(nums[que.peekFirst()]);
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }

}
