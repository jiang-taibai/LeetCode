package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Stack;

/**
 * <p>创建时间：2021/3/5 21:39</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_05 {
    public static void main(String[] args) {

    }

    class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        private boolean isOrder = false;    // 当isOrder为true时，set1.peek()就是队列的头部，表达的是此时栈头就是队头
        private Integer firstElement;   // 队头元素，仅在栈为空插入时 或 出队列时更新


        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack1.isEmpty()) {
                firstElement = x;
            }
            if (isOrder) {   // 如果栈头就是队头，那么需要先逆序再插入
                reOrder();
            }
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!isOrder) {   // 如果栈头不是队头， 那么需要先逆序，再删除栈头即队头
                reOrder();
            }
            int value = stack1.pop();
            if (!stack1.isEmpty()) {
                firstElement = stack1.peek();
            }
            return value;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return firstElement;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty();
        }

        public void reOrder() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1 = stack2;
            isOrder = !isOrder;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
