package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-26 09:23:13</p>
 */
public class DailyPractice_20241226 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean isSubstringPresent(String s) {
            Set<Integer> set = new HashSet<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) return true;
                int key = (chars[i] - 'a') * 100 + (chars[i + 1] - 'a');
                int reverseKey = (chars[i + 1] - 'a') * 100 + (chars[i] - 'a');
                if(set.contains(reverseKey)) return true;
                set.add(key);
            }
            return false;
        }
    }

}
