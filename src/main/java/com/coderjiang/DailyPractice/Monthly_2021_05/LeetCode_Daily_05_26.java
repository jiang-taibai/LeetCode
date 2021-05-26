package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Stack;

/**
 * <p>创建时间：2021/5/26 0:14</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_26 {

    class Solution {

        private Stack<StringBuilder> stack = new Stack<>();

        private void newStringPart() {
            stack.push(new StringBuilder(""));
        }

        private void reverse() {
            StringBuilder sb = stack.pop().reverse();
            stack.peek().append(sb);
        }

        private void append(Character ch) {
            stack.peek().append(ch);
        }

        public String reverseParentheses(String s) {
            stack.push(new StringBuilder(""));
            for (Character ch : s.toCharArray()) {
                if(ch.equals('(')) {
                    // 如果是左括号，就说明现在是新字符串了
                    newStringPart();
                } else if(ch.equals(')')) {
                    // 如果是右括号，就说明这是一个翻转序列了，需要反转当前字符串并且合并到上一个字符串中去
                    reverse();
                } else {
                    append(ch);
                }
            }
            return stack.peek().toString();
        }
    }

}
