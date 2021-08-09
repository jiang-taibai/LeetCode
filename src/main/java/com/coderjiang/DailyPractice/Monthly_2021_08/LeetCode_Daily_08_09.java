package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>Creation Time: 2021-08-09 11:40:03</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_09 {

    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            set.add(1L);
            pq.offer(1L);
            for (int i = 2; i <= n; ++i) {
                long cur = pq.poll();
                for (int prime : primes) {
                    long next = cur * prime;
                    if(set.add(next)) {
                        pq.offer(next);
                    }
                }
            }
            return Objects.requireNonNull(pq.poll()).intValue();
        }
    }

}
