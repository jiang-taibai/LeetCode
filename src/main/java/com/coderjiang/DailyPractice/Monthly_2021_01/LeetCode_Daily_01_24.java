package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/24 9:17</p>
 * <p>主要功能：给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_24 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int n = nums.length;
            if (n <= 1) return n;
            int pre = nums[0];
            int len = 1;
            int maxLen = 1;
            for (int i = 1; i < n; ++i) {
                if(nums[i] > pre) len++;
                else {
                    maxLen = Math.max(len, maxLen);
                    len = 1;
                }
                pre = nums[i];
            }
            return Math.max(len, maxLen);
        }
    }
}
