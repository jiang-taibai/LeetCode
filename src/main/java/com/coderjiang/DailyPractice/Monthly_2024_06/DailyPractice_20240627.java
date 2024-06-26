package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-27 03:45:18</p>
 */
public class DailyPractice_20240627 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String smallestString(String s) {
            // 特判：如果全'a'，那么将最后一个'a'换成'z'
            boolean allA = true;
            for (char c : s.toCharArray()) {
                if (c != 'a') {
                    allA = false;
                    break;
                }
            }
            if (allA) {
                return s.substring(0, s.length() - 1) + "z";
            }
            // 从第一个非'a'的字符开始，变到最后一个非'a'字符
            boolean start = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c != 'a') start = true;
                if (start && c == 'a') {
                    sb.append(s.substring(i));
                    break;
                }
                sb.append(start ? previousCharacter(c) : c);
            }
            return sb.toString();
        }

        private char previousCharacter(char c) {
            if (c == 'a') return 'z';
            return (char) (c - 1);
        }
    }

}
