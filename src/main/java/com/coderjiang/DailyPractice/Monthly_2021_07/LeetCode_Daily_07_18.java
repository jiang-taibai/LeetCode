package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.*;

/**
 * <p>Creation Time: 2021-07-18 10:02:27</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_18 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            char[] charArray;
            for (String str : strs) {
                charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortStr = String.valueOf(charArray);
                List<String> list = map.getOrDefault(sortStr, new ArrayList<String>());
                list.add(str);
                map.put(sortStr, list);
            }
            List<List<String>> res = new ArrayList<>();
            map.entrySet().forEach(entry -> res.add(entry.getValue()));
            return res;
        }
    }

}
