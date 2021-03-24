package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.TreeMap;

/**
 * <p>创建时间：2021/3/24 17:08</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_24 {

    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n <= 2) return false;
            int leftMin = nums[0];
            TreeMap<Integer, Integer> rightAll = new TreeMap<>();
            for (int j = 2; j < n; ++j) {
                rightAll.put(nums[j], rightAll.getOrDefault(nums[j], 0) + 1);
            }
            for (int j = 1; j < n - 1; ++j) {
                if(leftMin < nums[j]) {
                    Integer right = rightAll.ceilingKey(leftMin + 1);
                    if(right != null && right < nums[j]) {
                        return true;
                    }
                }
                leftMin = Math.min(leftMin, nums[j]);
                rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
                if(rightAll.get(nums[j + 1]) == 0) {
                    rightAll.remove(nums[j + 1]);
                }
            }
            return false;
        }
    }

}
