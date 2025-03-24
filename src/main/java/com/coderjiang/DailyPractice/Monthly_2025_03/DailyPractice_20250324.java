package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-24 09:50:19</p>
 */
public class DailyPractice_20250324 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countPrefixes(String[] words, String s) {
            int res = 0;
            for (String word : words) {
                if (word.length() > s.length()) continue;
                boolean valid = true;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != s.charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) ++res;
            }
            return res;
        }
    }
}
