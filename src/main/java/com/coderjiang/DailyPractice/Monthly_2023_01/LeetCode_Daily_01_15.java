package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-15 12:05:57</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_15 {

    static class Solution {
        // 方法一：递归法
        public int minMaxGame_1(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[] newNums = new int[n / 2];
            int newN = n / 2;
            for (int i = 0; i < newN; ++i) {
                if ((i & 1) == 0) {
                    // 偶数
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    // 奇数
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            return minMaxGame_1(newNums);
        }

        // 方法二：原地修改
        public int minMaxGame(int[] nums) {
            int n = nums.length;
            while (n != 1) {
                n = n / 2;
                for (int i = 0; i < n; ++i) {
                    if ((i & 1) == 0) nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                    else nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            return nums[0];
        }
    }

}
