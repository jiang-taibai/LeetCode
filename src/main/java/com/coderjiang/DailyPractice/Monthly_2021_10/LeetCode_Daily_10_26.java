package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>Creation Time: 2021-10-26 10:11:00</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_26 {

    class Solution {
        public int[] nextGreaterElement_Force(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] res = new int[n];
            int[] next = new int[10000 + 10];
            for (int i = 0; i < m; ++i) {
                next[nums2[i]] = -1;
                for (int j = i + 1; j < m; ++j) {
                    if (nums2[j] > nums2[i]) {
                        next[nums2[i]] = nums2[j];
                        break;
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                res[i] = next[nums1[i]];
            }
            return res;
        }

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> next = new HashMap<>();
            int n = nums2.length;
            for (int i = n - 1; i >= 0; --i) {
                int num = nums2[i];
                while (!stack.isEmpty() && num >= stack.peek()) stack.pop();
                next.put(num, stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }
            int m = nums1.length;
            int[] res = new int[m];
            for (int i = 0; i < m; ++i) {
                res[i] = next.get(nums1[i]);
            }
            return res;
        }
    }

}
