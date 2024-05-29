package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-29 23:07:25</p>
 */
public class DailyPractice_20240529 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximumLength(String s) {
            Map<String, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int n = chars.length;
            int maxLength = -1;
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < n; j++) {
                    if (j > i && chars[j] != chars[i]) break;
                    sb.append(chars[j]);
                    String key = sb.toString();
                    int value = map.getOrDefault(key, 0) + 1;
                    if (value >= 3) {
                        maxLength = Math.max(maxLength, key.length());
                        System.out.println("maxLength = " + maxLength);
                        System.out.println("key = " + key);
                    }
                    map.put(key, value);
                }
            }
            return maxLength;
        }
    }

}
