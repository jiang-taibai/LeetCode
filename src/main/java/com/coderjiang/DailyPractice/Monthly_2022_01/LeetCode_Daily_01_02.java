package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-02 00:25:26</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_02 {

    static class Solution {
        public int lastRemaining(int n) {
            int a0 = 1, d = 1;
            int loop_times = 1;
            int rest = n;
            while (rest != 1) {
                if (loop_times % 2 == 1) {
                    a0 += d;
                } else {
                    if (rest % 2 == 1) {
                        a0 += d;
                    }
                }
                loop_times++;
                d <<= 1;
                rest >>= 1;
            }
            return a0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 100; ++i) {
            System.out.println("i = " + i + ", res = " + solution.lastRemaining(i));
        }
    }

}
