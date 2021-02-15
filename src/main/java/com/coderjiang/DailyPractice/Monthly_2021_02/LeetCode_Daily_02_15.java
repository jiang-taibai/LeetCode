package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/15 11:08</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_15 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;
            int curr = 0, maxLen = 0;
            for (int i = 0; i < n; ++i) {
                if(nums[i]!=1) {
                    maxLen = Math.max(curr, maxLen);
                    curr = 0;
                } else {
                    curr++;
                }
            }
            return Math.max(curr, maxLen);
        }
    }
}
