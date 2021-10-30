package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-10-30 09:07:43</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_30 {

    class Solution {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num:nums) {
                if(!map.containsKey(num)) map.put(num, 0);
                map.put(num, map.get(num) + 1);
            }
            ArrayList<Integer> arr = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
                if(entry.getValue() == 1) arr.add(entry.getKey());
            }
            int[] res = new int[arr.size()];
            for(int i=0;i<arr.size();++i) res[i] = arr.get(i);
            return res;
        }
    }

}
