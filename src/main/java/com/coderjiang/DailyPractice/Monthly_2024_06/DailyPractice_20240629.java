package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-29 08:25:49</p>
 */
public class DailyPractice_20240629 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String removeTrailingZeros(String num) {
            int n = num.length();
            int endIndex = n;
            while (n - 1 >= 0 && num.charAt(n - 1) == '0') n--;
            return num.substring(0, n);
        }
    }

}
