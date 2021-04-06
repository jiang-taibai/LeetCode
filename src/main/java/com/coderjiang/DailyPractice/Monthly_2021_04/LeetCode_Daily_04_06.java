package com.coderjiang.DailyPractice.Monthly_2021_04;

/**
 * <p>创建时间：2021/4/6 16:55</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_04_06 {

    class Solution {

        private final Integer INVALID = 10000 + 10;

        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int del = 0;
            // 是否重复，重复就是true
            boolean isRepetition = false;
            // 重复部分的数字
            int preRepetition = INVALID;
            for (int i = 1; i < n; i++) {
                if (isRepetition) {
                    if (nums[i] == preRepetition) {
                        nums[i] = INVALID;
                        del++;
                    } else {
                        isRepetition = false;
                    }
                    continue;
                }
                if (nums[i - 1] == nums[i]) {
                    preRepetition = nums[i];
                    isRepetition = true;
                }
            }
            for (int i = 0; i < n; i++) {
                int j = 1;
                while (nums[i] == INVALID) {
                    nums[i] = nums[i + j];
                    nums[i + j] = INVALID;
                }
            }
            return n - del;
        }
    }

}
