package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.*;

/**
 * <p>Creation Time: 2021-08-27 16:56:23</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_27 {

    class MedianFinder {

        private final PriorityQueue<Integer> minQue = new PriorityQueue<>((a, b) -> (b - a));
        private final PriorityQueue<Integer> maxQue = new PriorityQueue<>((a, b) -> (a - b));

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (minQue.isEmpty() || num <= minQue.peek()) {
                minQue.offer(num);
                if (maxQue.size() + 1 < minQue.size()) {
                    maxQue.offer(minQue.poll());
                }
            } else {
                maxQue.offer(num);
                if (minQue.size() < maxQue.size()) {
                    minQue.offer(maxQue.poll());
                }
            }
        }

        public double findMedian() {
            if (minQue.size() > maxQue.size()) {
                return minQue.peek();
            }
            return (minQue.peek() + maxQue.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
