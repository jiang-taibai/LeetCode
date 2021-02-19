package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/19 10:20</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_19 {
    public static void main(String[] args) {

    }

    class Solution {
        public int longestOnes(int[] A, int k) {
            int ans = 0;
            int lhs = 0, lsum = 0, rsum = 0;
            int n = A.length;
            for (int rhs = 0; rhs < n; ++rhs) {
                rsum += 1 - A[rhs];
                while (rsum - lsum > k) {
                    lsum += 1 - A[lhs];
                    lhs++;
                }
                ans = Math.max(ans, rhs - lhs);
            }
            return ans;
        }
    }
}
