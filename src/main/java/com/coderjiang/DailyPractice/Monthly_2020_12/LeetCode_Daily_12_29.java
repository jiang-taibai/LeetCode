package com.coderjiang.DailyPractice.Monthly_2020_12;

/**
 * @author 刘江
 * @modifyTime 2020/12/29 16:09
 * @description TODO
 */
public class LeetCode_Daily_12_29 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int minPatches(int[] nums, int n) {
            int index = 0;
            int curr = 1;
            int count = 0;
            while(curr <= n) {
                if(index >= nums.length || nums[index] > curr) {
                    count++;
                    curr *= 2;
                } else {
                    curr += nums[index++];
                }
            }
            return count;
        }
    }
}
