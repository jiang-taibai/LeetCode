package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Stack;

/**
 * <p>创建时间：2021/3/11 13:58</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_11 {
    public static void main(String[] args) {
    }

    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char preOperator = '+';
            int num = 0;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    num = num * 10 + (ch - '0');
                }
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                    if (preOperator == '+') {
                        stack.push(num);
                    } else if (preOperator == '-') {
                        stack.push(-num);
                    } else if (preOperator == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                    preOperator = ch;
                    num = 0;
                }
            }
            int res = num;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }
}
