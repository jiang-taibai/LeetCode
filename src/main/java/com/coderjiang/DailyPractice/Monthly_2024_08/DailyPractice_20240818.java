package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-18 09:35:42</p>
 */
public class DailyPractice_20240818 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean checkRecord(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A') {
                    if (++count >= 2) return false;
                }
            }
            return !s.contains("LLL");
        }
    }

}
