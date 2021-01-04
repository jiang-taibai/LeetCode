package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * @author 刘江
 * @modifyTime 2021/1/4 10:25
 * @description TODO
 */
public class LeetCode_Daily_01_04 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int fib(int n) {
            if (n <= 1) return n;
            int f1 = 0, f2 = 1;
            int f = 1;
            for (int i = 2; i <= n; ++i) {
                f = f1 + f2;
                f1 = f2;
                f2 = f;
            }
            return f;
        }
    }
}
