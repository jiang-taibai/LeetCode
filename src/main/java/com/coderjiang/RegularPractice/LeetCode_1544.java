package com.coderjiang.RegularPractice;

import java.util.Stack;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/22 21:12
 * @description:
 * @get: 大写字母在前，两相差为32
 */
public class LeetCode_1544 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String makeGood(String s) {
            Stack<Character> stack = new Stack();
            for(Character c : s.toCharArray()) {
                if(stack.isEmpty()) {
                    stack.push(c);
                } else if(isWrong(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }

        private boolean isWrong(char c1, char c2) {
            return Math.abs(c1-c2)==32;
        }
    }
}
