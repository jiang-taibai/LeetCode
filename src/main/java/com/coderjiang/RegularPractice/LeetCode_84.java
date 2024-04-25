package com.coderjiang.RegularPractice;

import java.util.Stack;

/**
 * @author 刘江
 * @modifyTime 2020/12/26 19:38
 * @description 找一系列元素第一个比他大/小的元素用单调栈
 */
public class LeetCode_84 {
    public static void main(String[] args) {

    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            int maxArea = 0;
            for (int i = 0; i < n; i++) {
                maxArea = Math.max(maxArea, heights[i]*(right[i]-left[i]-1));
            }
            return maxArea;
        }
    }
}
