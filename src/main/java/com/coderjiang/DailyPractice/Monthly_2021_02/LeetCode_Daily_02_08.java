package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/8 10:03</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_08 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int maxLen = 0;
            int n = arr.length;
            int len = 1;
            for (int i = 0; i < n - 1; ++i) {
                if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                    len++;
                } else if (i % 2 != 0 && arr[i] < arr[i + 1]) {
                    len++;
                } else {
                    maxLen = Math.max(len, maxLen);
                    len = 1;
                }
            }
            maxLen = Math.max(len, maxLen);
            len = 1;
            for (int i = 0; i < n - 1; ++i) {
                if (i % 2 == 0 && arr[i] < arr[i + 1]) {
                    len++;
                } else if (i % 2 != 0 && arr[i] > arr[i + 1]) {
                    len++;
                } else {
                    maxLen = Math.max(len, maxLen);
                    len = 1;
                }
            }
            return Math.max(len, maxLen);
        }
    }
}
