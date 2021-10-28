package com.coderjiang.DailyPractice.Monthly_2021_10;

/**
 * <p>Creation Time: 2021-10-28 13:08:12</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_28 {

    class Solution {
        public boolean reorderedPowerOf2(int n) {
            int power = 1;
            long hashCode = getHashCode(n);
            for (int i = 0; i < 31; ++i) {
                if (getHashCode(power) == hashCode) return true;
                power *= 2;
            }
            return false;
        }

        private long getHashCode(int n) {
            long res = 0;
            while (n != 0) {
                res += Math.pow(10, n % 10);
                n /= 10;
            }
            return res;
        }

    }

}
