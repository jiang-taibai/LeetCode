package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-03 11:29:21</p>
 */
public class DailyPractice_20250203 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean validPalindrome(String s) {
            int n = s.length(), l = 0, r = n - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) break;
                l++;
                r--;
            }
            if (l >= r) return true;
            boolean valid = true;
            for (int i = 0; i < (r - l) / 2; i++) {
                if (s.charAt(l + i + 1) != s.charAt(r - i)) {
                    valid = false;
                    break;
                }
            }
            if (valid) return true;
            valid = true;
            for (int i = 0; i < (r - l) / 2; i++) {
                if (s.charAt(l + i) != s.charAt(r - i - 1)) {
                    valid = false;
                    break;
                }
            }
            return valid;
        }
    }

}
