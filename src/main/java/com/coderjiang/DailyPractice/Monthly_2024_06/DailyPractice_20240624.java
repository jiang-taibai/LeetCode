package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.Stack;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-24 00:30:16</p>
 */
public class DailyPractice_20240624 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            int[] res = new int[n];
            for (int i = 0; i < n+n; i++) {
                int num = nums[i];
                while (!stack.empty() && num > nums[stack.peek()]) {
                    res[stack.pop()] = num;
                }
                stack.push(i);
            }
            for (int num : nums) {
                while (!stack.empty() && num > nums[stack.peek()]) {
                    res[stack.pop()] = num;
                }
            }
            while (!stack.empty()) {
                res[stack.pop()] = -1;
            }
            return res;
        }
    }

}
