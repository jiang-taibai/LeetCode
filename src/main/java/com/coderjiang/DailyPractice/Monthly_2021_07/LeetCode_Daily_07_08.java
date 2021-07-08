package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-07-08 09:27:29</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_08 {

    class Solution {
        public int numSubarraysWithSum_hash(int[] nums, int goal) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            int[] leftSum = new int[n + 1]; // leftSum[i]表示nums[i-1]及i-1以前的和
            for (int i = 1; i < n + 1; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }
            int res = 0;
            for (int i = 0; i < n + 1; i++) {
                int need = leftSum[i] - goal;
                res += map.getOrDefault(need, 0);
                map.put(leftSum[i], map.getOrDefault(leftSum[i], 0) + 1);
            }
            return res;
        }

        public int numSubarraysWithSum_n2(int[] nums, int goal) {
            int n = nums.length;
            int[] leftSum = new int[n + 1]; // leftSum[i]表示nums[i-1]及i-1以前的和
            for (int i = 1; i < n + 1; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n + 1; j++) {
                    if(leftSum[j] - leftSum[i] == goal) res++;
                }
            }
            return res;
        }
    }

}
