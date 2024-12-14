package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-14 10:49:38</p>
 */
public class DailyPractice_20241214 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final long MOD = 1000000007L;

        public int[] getFinalState(int[] nums, int k, int multiplier) {
            if (multiplier == 1) return nums;
            int n = nums.length;
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                return Long.compare(a[1], b[1]);
            });
            int max = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
                pq.offer(new long[]{nums[i], i});
            }
            for (; k > 0 && pq.peek()[0] < max; --k) {
                long[] minNumItem = pq.poll();
                minNumItem[0] *= multiplier;
                pq.offer(minNumItem);
            }
            for (int i = 0; i < n; ++i) {
                long[] minNumItem = pq.poll();
                int power = (k / n) + (k % n > i ? 1 : 0);
                nums[(int) minNumItem[1]] = (int) ((minNumItem[0] % MOD) * this.fastPower(multiplier, power) % MOD);
            }
            return nums;
        }

        private long fastPower(long x, long n) {
            long res = 1;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res *= x;
                    res %= MOD;
                }
                x *= x;
                x %= MOD;
                n >>= 1;
            }
            return res;
        }
    }

}
