package com.coderjiang.DailyPractice.Monthly_2024_01;

import java.util.HashSet;

/**
 * <p>Creation Time: 2024-02-02</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_01_31 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int n = nums.length;
            HashSet<Integer> pre = new HashSet<>(), post = new HashSet<>();
            int[] preCount = new int[n], postCount = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre.add(nums[i]);
                preCount[i] = pre.size();
            }
            for (int i = n - 1; i >= 0; i--) {
                post.add(nums[i]);
                postCount[i] = post.size();
            }
            for (int i = 0; i < n; i++) {
                nums[i] = preCount[i] - postCount[i + 1];
            }
            return nums;
        }
    }

}
