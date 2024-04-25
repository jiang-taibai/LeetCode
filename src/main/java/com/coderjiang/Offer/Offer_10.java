package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-10 00:37:54</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_10 {

    class Solution {
        public int fib(int n) {
            if (n <= 1) return n;
            int a = 0, b = 1;
            for (int i = 2; i <= n; ++i) {
                int temp = (a + b) % 1000000007;
                a = b;
                b = temp;
            }
            return b;
        }
    }

}
