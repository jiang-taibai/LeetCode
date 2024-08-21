package com.coderjiang.DailyPractice.Monthly_2024_08;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-21 12:01:56</p>
 */
public class DailyPractice_20240821 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long findMaximumNumber(long k, int x) {
            long l = 1, r = (k + 1) << x;
            while (l < r) {
                long mid = (l + r + 1) / 2;
                if (calCumulativeValue(mid, x) <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }

        private long calCumulativeValue(long num, int x) {
            long res = 0;
            int length = 64 - Long.numberOfLeadingZeros(num);
            for (int i = x; i <= length; i += x) {
                res += accumulatedBitPrice(i, num);
            }
            return res;
        }

        public long accumulatedBitPrice(int x, long num) {
            long period = 1L << x;
            long res = period / 2 * (num / period);
            if (num % period >= period / 2) {
                res += num % period - (period / 2 - 1);
            }
            return res;
        }

    }

}
