package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间：2021/5/22 19:47</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_22 {

    class Solution {
        public boolean xorGame_wrong(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) ^ nums[i]);
            }
            int count = 0;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(entry.getValue() != 0) {
                    count++;
                }
            }
            return count % 2 == 0;
        }

        public boolean xorGame(int[] nums) {
            if (nums.length % 2 == 0) {
                return true;
            }
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            return xor == 0;
        }
    }

}
