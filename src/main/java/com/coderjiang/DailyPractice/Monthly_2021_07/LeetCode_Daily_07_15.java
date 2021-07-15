package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-07-15 15:40:50</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_15 {

    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int max = 1;
            int n = arr.length;
            arr[0] = 1; // 第一个必须是1
            for (int i = 1; i < n; ++i) {
                if (arr[i] > max) {
                    arr[i] = max + 1;
                    max++;
                }
            }
            return max;
        }
    }

}
