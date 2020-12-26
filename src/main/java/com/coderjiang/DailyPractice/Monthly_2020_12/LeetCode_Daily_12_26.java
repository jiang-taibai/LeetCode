package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Stack;

/**
 * @author 刘江
 * @modifyTime 2020/12/26 16:45
 * @description TODO
 */
public class LeetCode_Daily_12_26 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) return 0;
            int cols = matrix[0].length;
            int[] heights = new int[cols];
            int maxArea = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(matrix[i][j]=='1') {
                        heights[j] += 1;
                    } else heights[j] = 0;
                }
                maxArea = Math.max(maxArea, largestRectangleArea(heights));
            }
            return maxArea;
        }

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
                maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
            }
            return maxArea;
        }
    }
}
