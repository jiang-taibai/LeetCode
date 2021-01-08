package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * 创建时间：2021/1/8 0:59
 * 主要功能：TODO
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_08 {
    public static void main(String[] args) {

    }

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            for (int i = 0; i < k; ++i) {
                rotate_per(nums);
            }
        }

        private void rotate_per(int[] nums) {
            int num = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = num;
        }
    }
}
