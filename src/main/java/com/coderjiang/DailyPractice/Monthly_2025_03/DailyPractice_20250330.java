package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-30 20:45:37</p>
 */
public class DailyPractice_20250330 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int spacesIndex = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (spacesIndex < spaces.length && spaces[spacesIndex] == i) {
                    sb.append(' ');
                    spacesIndex++;
                }
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

}
