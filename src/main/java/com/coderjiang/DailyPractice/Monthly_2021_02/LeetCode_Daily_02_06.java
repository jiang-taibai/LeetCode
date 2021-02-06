package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/7 23:09</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_06 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkPossibility(int[] nums) {
            boolean flag = false;
            for(int i=1;i<nums.length;++i) {
                if(nums[i] < nums[i-1]) {
                    if(flag) return false;
                    flag = true;
                    if(i-2 >= 0 && nums[i-2]>nums[i]) {
                        nums[i] = nums[i-1];
                    } else nums[i-1] = nums[i];
                }
            }
            return true;
        }
    }
}
