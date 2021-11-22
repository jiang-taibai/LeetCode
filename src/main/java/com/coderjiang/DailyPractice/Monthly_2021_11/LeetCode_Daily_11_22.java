package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.Random;

/**
 * <p>Creation Time: 2021-11-22 11:59:29</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_22 {

    class Solution {

        private final int[] nums;
        private final int[] backups;

        public Solution(int[] nums) {
            this.nums = nums;
            backups = new int[nums.length];
            System.arraycopy(nums, 0, backups, 0, nums.length);
        }

        public int[] reset() {
            return backups;
        }

        public int[] shuffle() {
            Random rm = new Random();
            for (int i = nums.length - 1; i >= 0; --i) {
                int index = rm.nextInt(i + 1);
                swap(i, index);
            }
            return nums;
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    static class Foo {

        public static void main(String[] args) {
            String s = "smart";
            System.out.println("s = " + s);
            addChar(s, 'a');
            System.out.println("s = " + s);
        }

        public static void addChar(String temp, char ch) {
            temp = temp + ch;
        }
    }

}
