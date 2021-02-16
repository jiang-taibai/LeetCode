package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Arrays;

/**
 * <p>创建时间：2021/2/16 8:44</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_16 {
    public static void main(String[] args) {

    }

    class Solution {
        public int arrayPairSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < n; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
