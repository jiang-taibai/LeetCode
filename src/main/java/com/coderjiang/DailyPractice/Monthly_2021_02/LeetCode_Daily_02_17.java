package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/17 9:54</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_17 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int original_r = nums.length;
            int original_c = nums[0].length;
            if (original_c * original_r != r * c) {
                return nums;
            }

            int[][] new_nums = new int[r][c];
            for (int i = 0; i < original_r; ++i) {
                for (int j = 0; j < original_c; ++j) {
                    int totalIndex = i * original_c + j;
                    new_nums[totalIndex / c][totalIndex % c] = nums[i][j];
                }
            }
            return new_nums;
        }
    }
}
