package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>创建时间：2021/6/3 15:00</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_06_03 {

    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int cnt1 = 0, cnt0 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    cnt1++;
                } else {
                    cnt0++;
                }

                int value = cnt1 - cnt0;
                List<Integer> temp = map.getOrDefault(value, new LinkedList<>());
                temp.add(i);
                map.put(value, temp);
            }

            int maxLen = 0;
            if(map.containsKey(0)) {
                maxLen = map.get(0).get(map.get(0).size()-1) + 1;
            }
            for (Integer value : map.keySet()) {
                    List<Integer> list1 = map.get(value);
                    maxLen = Math.max(maxLen, list1.get(list1.size() - 1) - list1.get(0));
            }
            return maxLen;
        }
    }

}
