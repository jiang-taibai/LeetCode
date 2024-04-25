package com.coderjiang.Offer;

import java.util.Stack;

/**
 * <p>Creation Time: 2021-12-03 22:33:01</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_30 {


    class MinStack {

        private Stack<Integer> st1 = new Stack<>();
        private Stack<Integer> st2 = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (st2.empty() || st2.peek() >= x) st2.push(x);
            st1.push(x);
        }

        public void pop() {
            if (st1.pop().equals(st2.peek())) st2.pop();
        }

        public int top() {
            return st1.peek();
        }

        public int min() {
            return st2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

}
