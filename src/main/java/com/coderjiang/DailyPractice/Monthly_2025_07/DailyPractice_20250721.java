package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-21 20:43:40</p>
 */
public class DailyPractice_20250721 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
            char preChar = '^';
            int preCount = 1;
            for (char ch : s.toCharArray()) {
                if (ch != preChar) {
                    preChar = ch;
                    preCount = 1;
                } else {
                    preCount++;
                }
                if (preCount < 3) {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

}
