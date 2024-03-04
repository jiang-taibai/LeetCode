package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.Stack;

/**
 * <p>Creation Time: 2024/3/4</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_04 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
    }

    static class MyQueue {

        private final Stack<Integer> s1 = new Stack<>();
        private final Stack<Integer> s2 = new Stack<>();
        /**
         * 如果 reverse 为假，则 queue.peek() 在栈底
         * 反之在 栈顶
         */
        private boolean reverse = false;

        public MyQueue() {
        }

        private Stack<Integer> invert() {
            reverse = !reverse;
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) s2.push(s1.pop());
                return s2;
            } else {
                while (!s2.isEmpty()) s1.push(s2.pop());
                return s1;
            }
        }

        public void push(int x) {
            if (!reverse) {
                invert().push(x);
            } else {
                if (!s1.isEmpty()) s1.push(x);
                else s2.push(x);
            }
        }

        public int pop() {
            if (!s1.isEmpty()) {
                return reverse ? invert().pop() : s1.pop();
            } else {
                return reverse ? invert().pop() : s2.pop();
            }
        }

        public int peek() {
            if (!s1.isEmpty()) {
                return reverse ? invert().peek() : s1.peek();
            } else {
                return reverse ? invert().peek() : s2.peek();
            }
        }

        public boolean empty() {
            return s2.isEmpty() && s1.isEmpty();
        }
    }

}
