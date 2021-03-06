package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>创建时间：2021/3/6 18:47</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_06 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] nextGreaterElements_mine(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for (int i = 0; i < n; ++i) {
                int j = 1;
                for (j = 1; j < n; ++j) {
                    if (nums[(i + j) % n] > nums[i]) {
                        res[i] = nums[(i + j) % n];
                        break;
                    }
                }
                if (j >= n) res[i] = -1;
            }
            return res;
        }

        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < 2 * n ; ++i) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    res[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return res;
        }
    }
}
