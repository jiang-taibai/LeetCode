package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/4 9:47</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_03 {
    public static void main(String[] args) {

    }

    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double maxSum = 0, sum = 0;
            for (int i = 0; i < k; ++i) {
                sum += nums[i];
            }
            maxSum = sum;
            for (int i = k; i < nums.length; ++i) {
                sum += nums[i];
                sum -= nums[i - k];
                maxSum = Math.max(maxSum, sum);
            }
            return maxSum / k;
        }
    }
}
