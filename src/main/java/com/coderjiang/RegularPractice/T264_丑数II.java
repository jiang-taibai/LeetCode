package com.coderjiang.RegularPractice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2023-03-19 15:32:20</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T264_丑数II {

    static class Solution_PriorityQueue {
        public int nthUglyNumber(int n) {
            PriorityQueue<Number> queue = new PriorityQueue<>(Comparator.comparingLong(lhs -> lhs.val));
            HashSet<Long> set = new HashSet<>();
            queue.add(new Number(1));
            set.add(1L);
            int count = 1;
            long res = 1;
            while (count < n) {
                Number number = queue.peek();
                if (!number.hadMultiplyBy2) {
                    number.hadMultiplyBy2 = true;
                    if (!set.contains(number.val * 2)) {
                        set.add(number.val * 2);
                        queue.add(new Number(number.val * 2));
                    }
                } else if (!number.hadMultiplyBy3) {
                    number.hadMultiplyBy3 = true;
                    if (!set.contains(number.val * 3)) {
                        set.add(number.val * 3);
                        queue.add(new Number(number.val * 3));
                    }
                } else {
                    queue.poll();
                    count++;
                    if (!set.contains(number.val * 5)) {
                        set.add(number.val * 5);
                        queue.add(new Number(number.val * 5));
                    }
                }
            }
            return (int) queue.peek().val;
        }

        class Number {
            long val;
            boolean hadMultiplyBy2 = false;
            boolean hadMultiplyBy3 = false;
            boolean hadMultiplyBy5 = false;

            Number(long _val) {
                this.val = _val;
            }
        }
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            long[] dp = new long[n + 1];
            dp[1] = 1;
            int p1 = 1, p2 = 1, p3 = 1;
            for (int i = 2; i <= n; ++i) {
                dp[i] = Long.min(dp[p1] * 2L, Long.min(dp[p2] * 3L, dp[p3] * 5L));
                if (dp[i] == dp[p1] * 2) {
                    p1++;
                }
                if (dp[i] == dp[p2] * 3) {
                    p2++;
                }
                if (dp[i] == dp[p3] * 5) {
                    p3++;
                }
            }
            return (int) dp[n];
        }
    }

    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(10);
        System.out.println("i = " + i);
    }

}
