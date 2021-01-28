package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.Arrays;

/**
 * <p>创建时间：2021/1/28 9:07</p>
 * <p>主要功能：给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_28 {
    public static void main(String[] args) {

    }

    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];
            leftSum[0] = nums[0];
            rightSum[n - 1] = nums[n - 1];
            for (int i = 1; i < n; ++i) {
                leftSum[i] = leftSum[i - 1] + nums[i];
            }
            for (int i = n - 1; i >= 0; --i) {
                rightSum[i] = rightSum[i + 1] + nums[i];
            }
            for (int i = 0; i < n; ++i) {
                if (leftSum[i] == rightSum[i]) return i;
            }
            System.out.println(Arrays.toString(leftSum));
            System.out.println(Arrays.toString(rightSum));
            return -1;
        }
    }
}
