package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Arrays;

/**
 * <p>创建时间：2021/2/11 10:59</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_11 {
    public static void main(String[] args) {

    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    class KthLargest {

        private int[] nums;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = new int[k];
            Arrays.sort(nums);
            for (int i = 0; i < k; ++i) {
                int index = nums.length - 1 - i;
                this.nums[i] = index >= 0?nums[index]: -10000 - 10;
            }
            Arrays.sort(this.nums);
        }

        public int add(int val) {
            if (val < nums[0]) return nums[0];
            Arrays.sort(nums);
            nums[0] = val;
            Arrays.sort(nums);
            return nums[0];
        }
    }
}
