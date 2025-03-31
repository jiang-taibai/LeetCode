package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-31 13:27:32</p>
 */
public class DailyPractice_20250331 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int percentageLetter(String s, char letter) {
            int cnt = 0;
            for (char ch : s.toCharArray()) if (ch == letter) cnt++;
            return (int) (100.0 * cnt / s.length());
        }
    }

}
