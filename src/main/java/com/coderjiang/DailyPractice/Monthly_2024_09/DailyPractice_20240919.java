package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-19 10:14:05</p>
 */
public class DailyPractice_20240919 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int longestContinuousSubstring(String s) {
            int res = 1, cur = 1;
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i)-s.charAt(i-1)==1) cur++;
                else {
                    res = Math.max(res, cur);
                    cur = 1;
                }
            }
            return Math.max(res, cur);
        }
    }

}
