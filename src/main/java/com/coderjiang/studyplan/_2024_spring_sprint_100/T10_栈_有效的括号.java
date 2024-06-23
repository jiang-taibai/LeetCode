package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.Stack;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-21 17:44:14</p>
 */
public class T10_栈_有效的括号 {

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') stack.add(c);
                else {
                    if (stack.empty() || !match(stack.peek(), c)) return false;
                    stack.pop();
                }
            }
            return stack.empty();
        }

        private boolean match(char left, char right) {
            return (left == '(' && right == ')') ||
                    (left == '[' && right == ']') ||
                    (left == '{' && right == '}');

        }
    }

}
