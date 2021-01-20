package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.Arrays;

/**
 * <p>创建时间：2021/1/20 11:07</p>
 * <p>主要功能：给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_20 {
    public static void main(String[] args) {

    }

    class Solution {
        // O(n^3) 严重超时
        public int maximumProduct_drop(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int mul = nums[i] * nums[j] * nums[k];
                        if (mul > max) max = mul;
                    }
                }
            }
            return max;
        }

        public int maximumProduct(int[] nums) {
            Arrays.sort(nums); // 降序
            int n = nums.length;
            return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
        }
    }
}
