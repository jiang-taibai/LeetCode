package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>创建时间：2021/5/28 11:30</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_28 {

    class Solution {
        public int totalHammingDistance_set(int[] nums) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Object[] entries = map.entrySet().toArray();
            int n = entries.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                Map.Entry<Integer, Integer> e1 = (Map.Entry<Integer, Integer>) entries[i];
                for (int j = i + 1; j < n; j++) {
                    Map.Entry<Integer, Integer> e2 = (Map.Entry<Integer, Integer>) entries[j];
                    res += Integer.bitCount(e1.getKey() ^ e2.getKey()) * e1.getValue() * e2.getValue();
                }
            }
            return res;
        }

        public int totalHammingDistance_pure(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    res += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
            return res;
        }

        public int totalHammingDistance(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < 30; i++) {
                int c = 0;
                for (int num : nums) {
                    c += (num >> i) & 1;
                }
                res += c * (n - c);
            }
            return res;
        }
    }

}
