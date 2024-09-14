package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-14 21:27:24</p>
 */
public class DailyPractice_20240914 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String removeStars(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
                    else sb.append(c);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

}
