package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 00:48:19</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (maxIndex >= i) maxIndex = Math.max(maxIndex, i + nums[i]);
            else return false;      // 优化：剪纸
        }
        return maxIndex >= n - 1;
    }
}
