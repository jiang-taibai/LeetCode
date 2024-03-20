package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/20</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minNonZeroProduct(int p) {
            if (p == 1) {
                return 1;
            }
            long mod = 1000000007;
            long x = fastPow(2, p, mod) - 1;
            long y = (long) 1 << (p - 1);
            return (int) (fastPow(x - 1, y - 1, mod) * x % mod);
        }

        public long fastPow(long x, long n, long mod) {
            long res = 1;
            for (; n != 0; n >>= 1) {
                if ((n & 1) != 0) {
                    res = res * x % mod;
                }
                x = x * x % mod;
            }
            return res;
        }
    }

}

/*
- 1 2       3       4       5       6   7
- 1 (2+4)   3       4       (5-4)   6   7
- 1 (2+4)   (3-2)   (4+2)   (5-4)   6   7

a*b, x<max(a, b)
(a-x)*(b+x)=ab+(a-b)x-x^2=ab+(a-b-x)x
当 a-b-x < 0 时会变小，也就是 a-b<=x<max(a,b) 时会减小或不变，取
对于 2和5，取a=5,b=2,那么 3<=x<5，取最大的4
那么总共会减小 x^2-(a-b)x 值

*/