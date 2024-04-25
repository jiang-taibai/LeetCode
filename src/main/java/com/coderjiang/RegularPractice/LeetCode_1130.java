package com.coderjiang.RegularPractice;

import java.util.Stack;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 22:10
 * @description:
 * @get: Integer的最大值为Integer.MAX_VALUE
 */
public class LeetCode_1130 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int mctFromLeafValues(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            stack.push(Integer.MAX_VALUE);
            Integer result = 0;
            for(int val : arr) {
                while(stack.peek() < val) result += stack.pop() * Math.min(stack.peek(), val);
                stack.push(val);
            }
            while(stack.size()>2) result += stack.pop() * stack.peek();
            return result;
        }
    }
}
