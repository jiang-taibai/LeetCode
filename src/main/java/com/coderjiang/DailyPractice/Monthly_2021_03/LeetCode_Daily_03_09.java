package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Stack;

/**
 * <p>创建时间：2021/3/9 14:37</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_09 {
    public static void main(String[] args) {

    }

    class Solution {
        public String removeDuplicates(String str) {
            Stack<Character> stack = new Stack<>();
            for (Character ch : str.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != ch) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
}
