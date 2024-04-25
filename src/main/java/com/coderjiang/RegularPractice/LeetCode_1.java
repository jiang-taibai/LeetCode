package com.coderjiang.RegularPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>创建时间：2021/5/26 1:00</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i], list);
            }
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                int sub = target-entry.getKey();
                if(sub == entry.getKey() && entry.getValue().size() >= 2) {
                    return new int[]{entry.getValue().get(0), entry.getValue().get(1)};
                } else if(sub != entry.getKey() && map.containsKey(sub)) {
                    return new int[]{entry.getValue().get(0), map.get(sub).get(0)};
                }
            }
            return null;
        }
    }

}
