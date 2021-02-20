package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间：2021/2/20 11:38</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_20 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findShortestSubArray(int[] nums) {
            int lhs = 0, rhs = 0;
            int n = nums.length;

            int[] copy_nums = nums.clone();
            Arrays.sort(copy_nums);
            ArrayList<Integer> candidates = new ArrayList<>();
            int maxLen = 0, len = 1;
            for (int i = 0; i < copy_nums.length - 1; i++) {
                if (copy_nums[i] != copy_nums[i + 1]) {
                    if (len == maxLen) {
                        candidates.add(copy_nums[i]);
                    } else if (len > maxLen) {
                        maxLen = len;
                        candidates.clear();
                        candidates.add(copy_nums[i]);
                    }
                    len = 1;
                } else {
                    len++;
                }
            }

            if (len == maxLen) {
                candidates.add(copy_nums[n-1]);
            } else if (len > maxLen) {
                maxLen = len;
                candidates.clear();
                candidates.add(copy_nums[n-1]);
            }

            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                int num = nums[i];
                ArrayList<Integer> arr;
                if (!map.containsKey(num)) {
                    arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(i);
                } else {
                    arr = map.get(num);
                    arr.set(1, i);
                }
                map.put(num, arr);
            }

            int minLen = 50010;
            for (Integer candidate : candidates) {
                minLen = Math.min(map.get(candidate).get(1) - map.get(candidate).get(0) + 1, minLen);
            }
            return minLen;
        }
    }
}
