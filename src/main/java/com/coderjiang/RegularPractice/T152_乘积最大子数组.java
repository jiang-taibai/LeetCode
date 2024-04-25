package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-19 00:43:24</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T152_乘积最大子数组 {

    class Solution {

        private void analyse() {
            // 1. 如果数组有0
            //  那么就把数组从0切开，求子问题
            // 2. 如果数组没有0
            //  那么把数组从负数切开，再得到许多子数组
            // 3. 例如[5, 2, -3, 2, -2, 6, 0, 9, -2, 10, 1]
            //  分成[10, -3, 2, -2, 6], [9, -2, 10]，即将[5, 2]合成一个数字
            //  此时的问题变成:
            //      如果得到的子数组有偶数个负数，那么结果为所有元素之积
            //      如果有奇数个负数，那么分别取消最左边的负数和该负数左边的元素、最右边的负数和该负数右边的元素
            //      结果取最大值
        }

        public int maxProduct(int[] nums) {
            int n = nums.length;
            int left = 0;
            int res = -10;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    if (res == -10) res = 0;
                    res = Math.max(res, getSubArrayMaxProduct(nums, left, i - 1));
                    left = i + 1;
                }
            }
            res = Math.max(res, getSubArrayMaxProduct(nums, left, n - 1));
            return res;
        }

        private int getSubArrayMaxProduct(int[] nums, int left, int right) {
            if (left > right) return 0;
            else if (left >= nums.length || right < 0) return 0;
            else if (left == right) return nums[left];
            int numberOfNegative = 0;
            int multiply = 1;                       // 乘积
            int multiplyBeforeFirstNegative = 0;    // 第一个负数之前的乘积（包括负数）
            int multiplyBeforeLastNegative = 0;     // 最后一个负数之前的乘积（不包括负数）
            for (int i = left; i <= right; ++i) {
                if (nums[i] < 0) numberOfNegative++;
                multiply *= nums[i];
                if (nums[i] < 0 && multiplyBeforeFirstNegative == 0) multiplyBeforeFirstNegative = multiply;
                if (i + 1 <= right && nums[i + 1] < 0) multiplyBeforeLastNegative = multiply;
            }
            if (numberOfNegative % 2 == 0) return multiply;
            else return Math.max(multiply / multiplyBeforeFirstNegative, multiplyBeforeLastNegative);
        }
    }

}
