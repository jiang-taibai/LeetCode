package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Arrays;

/**
 * <p>创建时间：2021/2/6 12:22</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_05 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int lhs = 0, rhs = n - k - 1;
            // stream流效率慢，可用循环代替
            int total = Arrays.stream(cardPoints).sum();
            int sum = Arrays.stream(cardPoints).limit(rhs).sum();
            // System.out.println(sum);
            int minSum = sum;
            while (++rhs < n) {
                sum += cardPoints[rhs] - cardPoints[lhs];
                minSum = Math.min(minSum, sum);
            }
            return total - minSum;
        }
    }
}
