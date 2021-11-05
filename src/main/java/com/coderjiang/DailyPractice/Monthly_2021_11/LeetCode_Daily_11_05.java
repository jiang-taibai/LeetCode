package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-11-06 08:54:07</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_05 {

    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int n = arr.length;
            int[] dp = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            int max = 1;
            for (int i = 0; i < n; ++i) {
                int len = 1;
                int pre = arr[i] - difference;
                if (map.containsKey(pre)) len = map.get(pre) + 1;
                map.put(arr[i], len);
                max = Math.max(max, len);
            }
            return max;
        }
    }

}
