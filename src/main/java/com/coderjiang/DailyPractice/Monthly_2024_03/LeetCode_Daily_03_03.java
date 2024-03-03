package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Creation Time: 2024/3/3</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_03 {

    public static void main(String[] args) {
        MyStack solution = new MyStack();
    }

    static class MyStack {

        private final Queue<Integer> q1 = new LinkedList<>();
        private final Queue<Integer> q2 = new LinkedList<>();

        private boolean reverse = false;

        public MyStack() {
        }

        public void push(int x) {
            if(!reverse) {
                q2.offer(x);
                while(!q1.isEmpty()) q2.offer(q1.poll());
            } else {
                q1.offer(x);
                while(!q2.isEmpty()) q1.offer(q2.poll());
            }
            reverse = !reverse;
        }

        public int pop() {
            if(!reverse) {
                return q1.poll();
            } else {
                return q2.poll();
            }
        }

        public int top() {
            if(!reverse) {
                return q1.peek();
            } else {
                return q2.peek();
            }
        }

        public boolean empty() {
            if(!reverse) {
                return q1.isEmpty();
            } else {
                return q2.isEmpty();
            }
        }
    }

}
