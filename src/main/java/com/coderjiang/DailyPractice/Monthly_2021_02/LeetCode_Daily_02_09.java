package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/9 9:14</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_09 {
    public static void main(String[] args) {

    }

    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMostWithDistinct(A, K) - atMostWithDistinct(A, K - 1);
        }

        /**
         * @param A
         * @param K
         * @return 最多出现K次不同的数的数组个数
         */
        private int atMostWithDistinct(int[] A, int K) {
            int n = A.length;
            int lhs = 0, rhs = 0;
            int count = 0;
            int[] appear = new int[n + 1];
            int res = 0;
            while (rhs < n) {
                if (appear[A[rhs]] == 0) {
                    count++;
                }
                appear[A[rhs]]++;
                rhs++;
                while (count > K) {
                    if (appear[A[lhs]] == 1) {
                        count--;
                    }
                    appear[A[lhs]]--;
                    lhs++;
                }
                res += rhs - lhs;
            }
            return res;
        }
    }
}
