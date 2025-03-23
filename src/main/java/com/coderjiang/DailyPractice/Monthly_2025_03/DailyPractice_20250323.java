package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-23 17:55:39</p>
 */
public class DailyPractice_20250323 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean canBeValid(String s, String locked) {
            int left = 0, right = 0;
            int n = s.length();
            if (n == 1 || n % 2 == 1 || (s.charAt(0) == ')' && locked.charAt(0) == '1')) return false;
            for (int i = 0; i < n; ++i) {
                char c = s.charAt(i);
                char l = locked.charAt(i);
                if (l == '1' && c == ')') {
                    if (left > 0) left--;
                    else return false;
                } else {
                    left++;
                }
            }
            for (int i = n - 1; i >= 0; --i) {
                char c = s.charAt(i);
                char l = locked.charAt(i);
                if (l == '1' && c == '(') {
                    if (right > 0) right--;
                    else return false;
                } else {
                    right++;
                }
            }
            return true;
        }
    }

}
