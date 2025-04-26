package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-26 18:43:23</p>
 */
public class DailyPractice_20250426 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            // 把数组按照小于 minK 和大于 minK 的进行分割，分子情况讨论
            int n = nums.length;
            int lowerBound = 0;
            long res = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] < minK || nums[i] > maxK) {
                    res += count(nums, lowerBound, i - 1, minK, maxK);
                    lowerBound = i + 1;
                }
            }
            res += count(nums, lowerBound, n - 1, minK, maxK);
            return res;
        }

        private long count(int[] nums, int lower, int high, int minK, int maxK) {
            if (lower > high || lower >= nums.length || high >= nums.length) return 0;
            // Step-1 初始化
            Queue<Integer> minKIndexes = new LinkedList<>();
            Queue<Integer> maxKIndexes = new LinkedList<>();
            for (int i = lower; i <= high; ++i) {
                if (nums[i] == minK) minKIndexes.offer(i);
                if (nums[i] == maxK) maxKIndexes.offer(i);
            }

            // Step-2 遍历每个坐标，维护下一个 minK，maxK 的坐标，计算从当前坐标开头有多少种定界子数组
            long res = 0;
            for (int i = lower; i <= high; ++i) {
                if (!minKIndexes.isEmpty() && minKIndexes.peek() < i) minKIndexes.poll();
                if (!maxKIndexes.isEmpty() && maxKIndexes.peek() < i) maxKIndexes.poll();
                if (minKIndexes.isEmpty() || maxKIndexes.isEmpty()) break;
                res += high - Math.max(minKIndexes.peek(), maxKIndexes.peek()) + 1;
            }
            return res;
        }
    }

}
