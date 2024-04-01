package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Creation Time: 2024/4/1</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String finalString(String s) {
            final Deque<Character> deque = new LinkedList<>();
            boolean reverse = false;
            for (char c : s.toCharArray()) {
                if (c == 'i') reverse = !reverse;
                else {
                    if (!reverse) {
                        deque.offerLast(c);
                    } else {
                        deque.offerFirst(c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                if (!reverse) {
                    sb.append(deque.pollFirst());
                } else {
                    sb.append(deque.pollLast());
                }
            }
            return sb.toString();
        }
    }

}
