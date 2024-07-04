package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-04 11:13:03</p>
 */
public class TC0_贪心_最长回文串 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[256];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            int res = 0;
            boolean hasOdd = false;
            for (int i : count) {
                hasOdd = hasOdd || (i % 2 == 1);
                res += i / 2 * 2;
            }
            return hasOdd ? res + 1 : res;
        }
    }

}
